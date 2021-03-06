package observer.application.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
import java.util.Objects;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Table(name = "ITEM")
@Entity
public class Item {

    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotFound(action = NotFoundAction.IGNORE)
    private Long id;

    @Column(name = "ORIGIN_ID")
    private String originId;

    @Column(name = "SEARCH_ID")
    private Long searchId;

    @Column(name = "DATE_CREATED")
    private Instant dateCreated;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "URL")
    private String url;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "IS_NOTIFIED")
    private Boolean isNotified;

    @Column(name = "SOURCE_ID")
    private Integer sourceId;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Item other = (Item) obj;
        if (Objects.equals(originId, other.originId)) {
            return Objects.equals(sourceId, other.sourceId);
        }
        return false;
    }

}
