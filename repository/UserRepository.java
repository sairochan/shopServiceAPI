package org.backend.foulproofexam.repository;

import java.util.List;

import org.backend.foulproofexam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
