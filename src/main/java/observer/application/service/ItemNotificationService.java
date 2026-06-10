package observer.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.mapper.ItemMapper;
import observer.application.model.Item;
import observer.application.repository.ItemRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.ByteArrayInputStream;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemNotificationService {

    private static final PageRequest PAGE_REQUEST = PageRequest.of(0, 100);
    private static final String MESSAGE_CONTENT = "%s new items";

    private final NotificationService notificationService;
    private final FtpService ftpService;

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper = new ItemMapper();

    @Transactional
    public void execute() {
        List<Item> items = itemRepository.findByIsDeletedFalseAndIsNotificationSentFalseOrderByCreatedDateDesc(PAGE_REQUEST);
        if (!items.isEmpty()) {
            try {
                uploadItemListFile();
            } catch (Exception e) {
                log.error("Item list upload failed", e);
            }

            try {
                sendPushNotification(items);
            } catch (Exception e) {
                log.error("Notification send failed", e);
            }
            items.forEach(i -> i.setIsNotificationSent(true));
        }
    }

    private void sendPushNotification(List<Item> items) {
        String messageTitle = "New items found!";
        String messageContent = String.format(MESSAGE_CONTENT, items.size());
        notificationService.sendNotification(messageTitle, messageContent);
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
}
