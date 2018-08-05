package allegro.application.repository;

import allegro.application.entity.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i WHERE i.searchId =:searchId AND i.isActive = true")
    Optional<List<Item>> findActiveItems(@Param("searchId") Long searchId);
}
