package com.example.demo.repository;

import com.example.demo.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

// SQL queries
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    /*JpaRepository will have all the functions of CrudRepository and PagingAndSortingRepository. So if you don't need
     the repository to have the functions provided by JpaRepository and PagingAndSortingRepository , use CrudRepository.*/

    //List<Comment> findByAuthor(String author);

    @Query("SELECT c FROM Comment c WHERE c.post.id = :id")
    List<Comment> findByPostId(String id);
}