package allegro.app.repository;

import allegro.app.entity.Search;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@ComponentScan(basePackageClasses = Search.class)
public interface SearchRepository extends JpaRepository<Search, Long> {

    @Modifying
    @Query("UPDATE Search s SET s.isActive = CASE WHEN s.isActive = true THEN false ELSE true END WHERE s.id =:searchId")
    void switchIsActive(@Param("searchId") Long searchId);

    @Query("SELECT s FROM Search s WHERE s.isActive = true")
    List<Search> fetchActiveSearchList();

    @Query("SELECT s FROM Search s WHERE s.id =:searchId")
    Search findBySearchId(@Param("searchId") Long searchId);
}
