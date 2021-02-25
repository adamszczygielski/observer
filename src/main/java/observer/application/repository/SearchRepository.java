package observer.application.repository;

import observer.application.domain.Search;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface SearchRepository extends JpaRepository<Search, Long> {

    @Query("SELECT s FROM Search s WHERE NOW() > DATEADD(MINUTE, s.timeInterval, s.dateUpdated) OR s.dateUpdated IS NULL ORDER BY s.dateUpdated")
    List<Search> findOverdue(Pageable pageable);

    @Modifying
    @Query("DELETE FROM Search s WHERE s.id IN :searchIds")
    void deleteByIds(@Param("searchIds") List<Long> searchIds);
}
