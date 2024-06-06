package com.sample.caffeinespringboot.persistence.repository;

import com.sample.caffeinespringboot.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
