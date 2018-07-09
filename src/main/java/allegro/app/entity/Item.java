package allegro.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private Long itemId;

    @Column(name = "SEARCH_ID")
    private Long searchId;

    @Column(name = "CREATION_DATE")
    private Timestamp creationDate;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "URL")
    private String url;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;
}
