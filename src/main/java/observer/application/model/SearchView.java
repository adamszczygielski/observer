package observer.application.model;

import lombok.Getter;
import org.hibernate.annotations.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Getter
@Table(name = "SEARCHES_V")
@Entity
@Immutable
public class SearchView {

    @Id
    private Long id;
    private String description;
    private String params;
    private Instant lastExecutionDate;
    private Short intervalMinutes;
    private Integer sourceId;
    private Integer statusId;
    private Integer count;
}
