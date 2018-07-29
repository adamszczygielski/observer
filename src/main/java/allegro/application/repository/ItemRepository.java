package allegro.application.repository;

import allegro.application.entity.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i WHERE i.searchId =:searchId AND i.isActive = true")
    List<Item> findActiveItems(@Param("searchId") Long searchId);
}
