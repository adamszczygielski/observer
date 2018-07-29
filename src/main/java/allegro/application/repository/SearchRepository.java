package allegro.application.repository;

import allegro.application.entity.Search;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@ComponentScan(basePackageClasses = Search.class)
public interface SearchRepository extends JpaRepository<Search, Long> {
}
