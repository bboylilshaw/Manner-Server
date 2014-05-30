package com.hp.manner.repository;

import com.hp.manner.model.ActionItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public class ActionItemRepository implements MongoRepository<ActionItem, String> {

}
