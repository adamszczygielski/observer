package observer.application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ITEM")
@Entity
public class Item implements Serializable {

    @Id
    @Column(name = "ID", unique=true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotFound(action= NotFoundAction.IGNORE)
    private Long id;

    @Column(name = "ORIGIN_ID")
    private String originId;

    @Column(name = "SEARCH_ID")
    private Long searchId;

    @Column(name = "DATE_CREATED")
    private Timestamp dateCreated;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "URL")
    private String url;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "SEARCH_ID", insertable = false, updatable = false)
//    private Search search;
}