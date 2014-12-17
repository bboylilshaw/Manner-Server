package com.hp.manner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hp.manner.domain.Group;
import com.hp.manner.domain.User;

@RepositoryRestResource(collectionResourceRel = "groups", path = "groups")
public interface GroupRepository extends JpaRepository<Group, Long> {
	List<Group> findByOwner(User owner);
}
