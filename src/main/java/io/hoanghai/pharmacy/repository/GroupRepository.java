package io.hoanghai.pharmacy.repository;

import io.hoanghai.pharmacy.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("groupRepository")
public interface GroupRepository extends JpaRepository<Group, Integer> {
    Group findByName(String name);
}
