package observer.application.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "ITEMS")
@Entity
public class Item {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotFound(action = NotFoundAction.IGNORE)
    private Long id;

    @Column(name = "ORIGIN_ID")
    @EqualsAndHashCode.Include
    private String originId;

    @Column(name = "SOURCE_ID")
    @EqualsAndHashCode.Include
    private Integer sourceId;

    @Column(name = "SEARCH_ID")
    private Long searchId;

    @Column(name = "CREATED_DATE")
    private Instant createdDate;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "URL")
    private String url;

    @Column(name = "IS_DELETED")
    private Boolean isDeleted;

    @Column(name = "IS_NOTIFICATION_SENT")
    private Boolean isNotificationSent;


}
