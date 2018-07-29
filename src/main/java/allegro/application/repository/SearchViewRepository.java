package allegro.application.repository;

import allegro.application.entity.Item;
import allegro.application.entity.SearchView;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@ComponentScan(basePackageClasses = Item.class)
public interface SearchViewRepository extends JpaRepository<SearchView, Long>{
}
