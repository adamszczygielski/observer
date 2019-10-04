package allegro.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ITEM")
@Entity
public class Item implements Serializable {

    @Id
    @Column(name = "ITEM_ID")
    @NotFound(action= NotFoundAction.IGNORE)
    private Long itemId;

    @Column(name = "SEARCH_ID")
    private Long searchId;

    @Column(name = "CREATION_DATE")
    private Timestamp creationDate;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SEARCH_ID", insertable = false, updatable = false)
    private Search search;
}
