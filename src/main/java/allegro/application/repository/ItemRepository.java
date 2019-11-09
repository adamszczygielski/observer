package allegro.application.repository;

import allegro.application.domain.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i WHERE i.searchId =:searchId AND i.isActive = true")
    Optional<List<Item>> findActiveItemsBySeachId(@Param("searchId") Long searchId);

    @Query("SELECT i FROM Item i WHERE i.isActive = true")
    Optional<List<Item>> findActiveItems();
}
