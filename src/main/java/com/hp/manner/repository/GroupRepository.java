package com.hp.manner.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.hp.manner.domain.Group;
import com.hp.manner.domain.User;

@RepositoryRestResource(collectionResourceRel = "groups", path = "groups")
public interface GroupRepository extends JpaRepository<Group, Long> {
	List<Group> findByOwner(User owner);
	
	@JoinTable(
	          name = "t_group_user",
	          joinColumns = @JoinColumn(name = "group_id"),
	          inverseJoinColumns = @JoinColumn(name = "user_id")
		)
		@Query(value="select a from User a where a.id=:groupId")
		Collection<User> findUsers(@Param("groupId")Long groupId);
}
