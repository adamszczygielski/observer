package observer.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import observer.application.config.ApplicationConfig;
import observer.application.model.Item;
import observer.application.model.Source;
import observer.application.repository.ItemRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemNotificationService {

    private static final PageRequest PAGE_REQUEST = PageRequest.of(0, 100);
    private static final String MESSAGE_HEADER = "Found %s new item%s!";
    private static final String MESSAGE_FOOTER = "and %s more...";
    private static final short ITEMS_DISPLAY_LIMIT = 5;

    private final NotificationService notificationService;
    private final ItemRepository itemRepository;
    private final ApplicationConfig applicationConfig;

    public void execute() {
        List<Item> items = itemRepository
                .findByIsDeletedFalseAndIsNotificationSentFalseOrderByCreatedDateDesc(PAGE_REQUEST);
        if (!items.isEmpty()) {
            List<Long> itemIds = items.stream()
                    .map(Item::getId)
                    .collect(Collectors.toList());
            itemRepository.setIsNotificationSentTrue(itemIds);
            notificationService.sendNotification(createMessage(items));
        }
    }

    public long getDelaySeconds() {
        return applicationConfig.getNotificationDelaySeconds();
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
