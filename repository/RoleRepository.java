package org.backend.foulproofexam.repository;

import org.backend.foulproofexam.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}