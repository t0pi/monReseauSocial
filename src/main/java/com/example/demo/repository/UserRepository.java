package com.example.demo.repository;

import com.example.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /*JpaRepository will have all the functions of CrudRepository and PagingAndSortingRepository. So if you don't need
     the repository to have the functions provided by JpaRepository and PagingAndSortingRepository , use CrudRepository.*/
    
    @Query("SELECT b FROM User b WHERE b.name LIKE %:name%")
    List<User> findByName(String name);

    @Query("SELECT b FROM User b WHERE b.mail LIKE :mail")
    List<User> findByMail(String mail);
}