package allegro.application.domain;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PARAMETER")
@Entity
public class Parameter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "SEARCH_ID")
    Long searchId;

    @Column(name = "TYPE_ID")
    Long typeId;

    @Column(name = "VALUE")
    String value;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "SEARCH_ID", insertable = false, updatable = false)
//    private Search search;
}
