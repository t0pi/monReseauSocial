package com.example.demo.repository;

import com.example.demo.pojo.Post;
import com.example.demo.pojo.PostJSON;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// SQL queries
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    /*JpaRepository will have all the functions of CrudRepository and PagingAndSortingRepository. So if you don't need
     the repository to have the functions provided by JpaRepository and PagingAndSortingRepository , use CrudRepository.*/
    @Query("SELECT b FROM Post b ORDER BY b.postdate DESC")
    List<Post> findAll();

    List<Post> findByAuthor(String author);

    @Query("SELECT b FROM Post b WHERE b.title LIKE %:title%")
    List<Post> findByTitle(String title);
//
//    @Query("SELECT c FROM Comment c JOIN Post ON Comment.postId JOIN User ON Comment.author = User.id ORDER BY Comment.date ")
//    List<Post> findAllPosts();
}
