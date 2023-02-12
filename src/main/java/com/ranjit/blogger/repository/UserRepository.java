package com.ranjit.blogger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ranjit.blogger.entity.UsersEntity;
@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Integer> {
	
	

}
