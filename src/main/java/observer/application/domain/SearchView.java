package observer.application.domain;

import lombok.Getter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Table(name = "SEARCH_V")
@Entity
@Immutable
public class SearchView {

    @Id
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
    private Long timeInterval;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "SOURCE_ID")
    private Long sourceId;

    @Column(name = "COUNT")
    private Long count;
}
