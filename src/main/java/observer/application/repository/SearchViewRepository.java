package observer.application.repository;

import observer.application.model.SearchView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchViewRepository extends JpaRepository<SearchView, Long> {
}
