package allegro.app.entity;

import allegro.app.common.Utils;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Table(name = "SEARCH_V")
@Entity
public class SearchView implements Serializable {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "KEYWORD")
    private String keyword;

    @Column(name = "CATEGORY")
    private String category;

    @Getter(AccessLevel.NONE)
    @Column(name = "LAST_UPDATE")
    private Timestamp lastUpdate;

    @Column(name = "TIME_INTERVAL")
    private Long timeInterval;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "COUNT")
    private Long count;

    public String getLastUpdate() {
        return Utils.timestampToShortString(lastUpdate);
    }
}
