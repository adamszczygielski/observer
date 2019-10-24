package allegro.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @Column(name = "LAST_UPDATE")
    private Timestamp lastUpdate;

    @Column(name = "TIME_INTERVAL")
    private Long timeInterval;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "SOURCE")
    private String source;

    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "SEARCH_ID")
    private List<Item> itemList;
}
