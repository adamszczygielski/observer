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

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "DATE_UPDATED")
    private Timestamp dateUpdated;

    @Column(name = "TIME_INTERVAL")
    private Long timeInterval;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "SOURCE_ID")
    private Long sourceId;

    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SEARCH_ID")
    private List<Item> itemList;

    @OneToMany(cascade =  CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "SEARCH_ID")
    private List<Parameter> parameterList;
}