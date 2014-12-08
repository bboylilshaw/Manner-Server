package com.hp.manner.repository;

import com.hp.manner.domain.Group;
import com.hp.manner.domain.Item;
import com.hp.manner.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "items", path = "/items")
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Override
    @RestResource(exported = false)
    void delete(Long id);

    @Override
    @RestResource(exported = false)
    void delete(Item item);

    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends Item> items);

    @Override
    @RestResource(exported = false)
    void deleteAll();

    @RestResource(rel = "getItemsByOwner", path = "/owner")
    List<Item> findByOwner(@Param("ownerId") User owner);

    @RestResource(rel = "getItemsByGroup", path = "/group")
    List<Item> findByGroup(@Param("groupId") Group group);

    @RestResource(rel = "countCompletionItemsAfterDate", path = "/countAfterDate")
    long countByOwnerAndCompletionDateAfter(@Param("ownerId") User owner,
                                            @Param("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date);

    @RestResource(rel = "countCompletionItemsBetweenDate", path = "/countBetweenDate")
    long countByOwnerAndCompletionDateBetween(@Param("ownerId") User owner,
                                              @Param("beginDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date beginDate,
                                              @Param("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate);

}
