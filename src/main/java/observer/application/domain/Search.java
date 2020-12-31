package observer.application.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SEARCH")
@Entity
public class Search {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "KEYWORD")
    private String keyword;

    @Column(name = "CATEGORY_ID")
    private String categoryId;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Column(name = "PRICE_FROM")
    private Integer priceFrom;

    @Column(name = "PRICE_TO")
    private Integer priceTo;

    @Column(name = "DATE_UPDATED")
    private Timestamp dateUpdated;

    @Column(name = "TIME_INTERVAL")
    private Short timeInterval;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "SOURCE_ID")
    private Long sourceId;

    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SEARCH_ID")
    private List<Item> itemList;

}
