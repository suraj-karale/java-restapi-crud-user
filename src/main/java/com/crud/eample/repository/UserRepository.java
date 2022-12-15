package com.crud.eample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.eample.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
