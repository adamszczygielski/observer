package observer.application.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "SEARCHES")
@Entity
public class Search {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "KEYWORD")
    @EqualsAndHashCode.Include
    private String keyword;

    @Column(name = "CATEGORY_ID")
    @EqualsAndHashCode.Include
    private String categoryId;

    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @Column(name = "PRICE_FROM")
    private Integer priceFrom;

    @Column(name = "PRICE_TO")
    private Integer priceTo;

    @Column(name = "LAST_EXECUTION_DATE")
    private Instant lastExecutionDate;

    @Column(name = "INTERVAL_MINUTES")
    private Short intervalMinutes;

    @Column(name = "SOURCE_ID")
    @EqualsAndHashCode.Include
    private Integer sourceId;

    @Column(name = "STATUS_ID")
    private Integer statusId;

    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SEARCH_ID")
    private List<Item> items;

    @Override
    public String toString() {
        return "Search{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", priceFrom=" + priceFrom +
                ", priceTo=" + priceTo +
                ", lastExecutionDate=" + lastExecutionDate +
                ", intervalMinutes=" + intervalMinutes +
                ", sourceId=" + sourceId +
                ", statusId=" + statusId +
                '}';
    }

}
