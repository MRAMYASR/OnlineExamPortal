package com.capg.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
