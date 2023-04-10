package observer.application.repository;

import observer.application.model.Search;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchRepository extends JpaRepository<Search, Long> {

    @Query("SELECT s FROM Search s " +
            "WHERE s.sourceId = :sourceId " +
            "AND (NOW() > DATEADD(MINUTE, s.intervalMinutes, s.lastExecutionDate) OR s.lastExecutionDate IS NULL) " +
            "ORDER BY s.lastExecutionDate")
    List<Search> findOverdue(Integer sourceId, Pageable pageable);

    @Modifying
    void deleteByIdIn(List<Long> ids);
}
