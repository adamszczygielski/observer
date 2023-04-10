package observer.application.repository;

import observer.application.model.Item;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByIsDeletedFalseAndSearchIdOrderByCreatedDateDesc(Long searchId);

    List<Item> findByIsDeletedFalseOrderByCreatedDateDesc();

    List<Item> findByIsDeletedFalseAndIsNotificationSentFalseOrderByCreatedDateDesc(Pageable pageable);

    @Query("SELECT i.originId FROM Item i WHERE i.sourceId = :sourceId")
    Set<String> findOriginIds(Integer sourceId);

    @Modifying
    @Transactional
    @Query("UPDATE Item i SET i.isNotificationSent = true WHERE i.id IN :itemIds")
    void setIsNotificationSentTrue(List<Long> itemIds);

    @Modifying
    @Transactional
    @Query("UPDATE Item i SET i.isDeleted = true WHERE i.id IN :itemIds")
    void setIsDeletedTrue(List<Long> itemIds);

}
