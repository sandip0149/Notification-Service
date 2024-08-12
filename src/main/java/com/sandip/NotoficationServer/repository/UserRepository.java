package com.sandip.NotoficationServer.repository;


import com.sandip.NotoficationServer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
