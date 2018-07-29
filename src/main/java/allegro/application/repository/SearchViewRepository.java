package allegro.application.repository;

import allegro.application.entity.SearchView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchViewRepository extends JpaRepository<SearchView, Long>{
}
