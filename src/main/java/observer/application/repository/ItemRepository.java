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

    @Query("SELECT i FROM Item i WHERE i.searchId =:searchId AND i.isActive = true ORDER BY i.dateCreated DESC")
    Optional<List<Item>> findActive(@Param("searchId") Long searchId);

    @Query("SELECT i FROM Item i WHERE i.isActive = true ORDER BY i.dateCreated DESC")
    Optional<List<Item>> findActive();

    @Modifying
    @Query("UPDATE Item i SET i.isActive = false WHERE i.id =:itemId")
    void setInactive(@Param("itemId") Long itemId);

    @Modifying
    @Query("UPDATE Item i SET i.isActive = false WHERE i.id IN :itemIds")
    void setInactive(@Param("itemIds") List<Long> itemIds);
}
