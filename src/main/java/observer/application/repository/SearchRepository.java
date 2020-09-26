package observer.application.repository;

import observer.application.domain.Search;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Transactional
@Repository
public interface SearchRepository extends JpaRepository<Search, Long> {

    @Query("FROM Search s WHERE :now > DATEADD(MINUTE, s.timeInterval, s.dateUpdated) ORDER BY s.dateUpdated")
    List<Search> findAllToUpdate(@Param("now") Timestamp now, Pageable pageable);

    @Modifying
    @Query("DELETE FROM Search s WHERE s.id IN :searchIds")
    void deleteByIds(@Param("searchIds") List<Long> searchIds);
}
