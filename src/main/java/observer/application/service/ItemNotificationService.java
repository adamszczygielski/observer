package observer.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.config.ApplicationConfig;
import observer.application.dto.Source;
import observer.application.mapper.ItemMapper;
import observer.application.model.Item;
import observer.application.repository.ItemRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemNotificationService {

    private static final PageRequest PAGE_REQUEST = PageRequest.of(0, 100);
    private static final String MESSAGE_HEADER = "Found %s new item%s!";
    private static final String MESSAGE_FOOTER = "and %s more...";
    private static final short ITEMS_DISPLAY_LIMIT = 5;

    private final NotificationService notificationService;
    private final FtpService ftpService;
    private final ItemRepository itemRepository;
    private final ApplicationConfig applicationConfig;
    private final ItemMapper itemMapper = new ItemMapper();

    public void execute() {
        if (sendPushNotification()) {
            uploadItemListFile();
        }
    }

    public Duration getDelay() {
        return applicationConfig.getItemsNotificationDelay();
    }

    private boolean sendPushNotification() {
        List<Item> items = itemRepository.findByIsDeletedFalseAndIsNotificationSentFalseOrderByCreatedDateDesc(PAGE_REQUEST);
        if (!items.isEmpty()) {
            itemRepository.setIsNotificationSentTrue(items.stream().map(Item::getId).toList());
            notificationService.sendNotification(createMessage(items));
            return true;
        }
        return false;
    }

    private void uploadItemListFile() {
        String html = generateHtml(itemRepository.findByIsDeletedFalseOrderByCreatedDateDesc(PAGE_REQUEST));
        ftpService.uploadFile(new ByteArrayInputStream(html.getBytes()));
    }

    private String generateHtml(List<Item> items) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        context.setVariable("items", itemMapper.toDtoList(items));
        return templateEngine.process("templates/items-min.html", context);
    }

    private String createMessage(List<Item> items) {
        StringBuilder stringBuilder = new StringBuilder();
        appendMessageHeader(stringBuilder, items.size());
        appendMessageBody(stringBuilder, items);
        appendMessageFooter(stringBuilder, items.size());
        return stringBuilder.toString();
    }

    private void appendMessageHeader(StringBuilder stringBuilder, int itemsCount) {
        stringBuilder.append(String.format(MESSAGE_HEADER, itemsCount, itemsCount == 1 ? "" : "s"));
    }

    private void appendMessageBody(StringBuilder stringBuilder, List<Item> items) {
        items.stream()
                .limit(ITEMS_DISPLAY_LIMIT)
                .forEach(i -> stringBuilder.append("\n")
                        .append(StringUtils.abbreviate(i.getTitle(), 30))
                        .append(", ")
                        .append(i.getPrice())
                        .append(", ")
                        .append(Source.getLabel(i.getSourceId())));
    }

    private void appendMessageFooter(StringBuilder stringBuilder, int itemsCount) {
        if (itemsCount > ITEMS_DISPLAY_LIMIT) {
            stringBuilder.append("\n").append(String.format(MESSAGE_FOOTER, itemsCount - ITEMS_DISPLAY_LIMIT));
        }
    }
}
