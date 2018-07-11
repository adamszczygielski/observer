package allegro.app.repository;

import allegro.app.entity.Item;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@ComponentScan(basePackageClasses = Item.class)
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Modifying
    @Query("UPDATE Item i SET i.isActive = CASE WHEN i.isActive = true THEN false ELSE true END WHERE i.itemId =:itemId")
    void switchIsActive(@Param("itemId") Long itemId);

    @Query("SELECT i FROM Item i WHERE i.searchId =:searchId AND i.isActive = true")
    List<Item> findActiveItems(@Param("searchId") Long searchId);

    @Query("SELECT i.itemId FROM Item i")
    List<Long> fetchItemIds();
}
