package observer.application.repository;

import observer.application.model.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query("SELECT i FROM Item i WHERE i.searchId = :searchId AND i.isActive = true ORDER BY i.dateCreated DESC")
    Optional<List<Item>> findActive(@Param("searchId") Long searchId);

    @Query("SELECT i FROM Item i WHERE i.isActive = true ORDER BY i.dateCreated DESC")
    Optional<List<Item>> findActive();

    @Query("SELECT i.id FROM Item i WHERE i.isActive = true AND i.isNotified = false ORDER BY i.dateCreated")
    Optional<List<Long>> findActiveAndNotNotified(Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE Item i SET i.isNotified = true WHERE i.id IN :itemIds")
    void setNotified(@Param("itemIds") List<Long> itemIds);

    @Modifying
    @Transactional
    @Query("UPDATE Item i SET i.isActive = false WHERE i.id IN :itemIds")
    void setInactive(@Param("itemIds") List<Long> itemIds);

}
