package observer.application.repository;

import observer.application.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i WHERE i.searchId =:searchId AND i.isActive = true")
    Optional<List<Item>> findActiveItemsBySearchId(@Param("searchId") Long searchId);

    @Query("SELECT i FROM Item i WHERE i.isActive = true")
    Optional<List<Item>> findActiveItems();

    @Modifying
    @Query("UPDATE Item i SET i.isActive = false WHERE i.id =:itemId")
    void setItemInactive(@Param("itemId") Long itemId);
}
