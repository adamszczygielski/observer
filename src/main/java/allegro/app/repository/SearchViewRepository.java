package allegro.app.repository;

import allegro.app.entity.Item;
import allegro.app.entity.SearchView;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan(basePackageClasses = Item.class)
public interface SearchViewRepository extends JpaRepository<SearchView, Long>{

    @Query("SELECT s FROM SearchView s")
    List<SearchView> findSearch();
}
