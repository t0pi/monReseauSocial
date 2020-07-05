package com.example.demo.repository;
import com.example.demo.pojo.Likes;
import com.example.demo.pojo.Post;
import com.example.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LikesRepository extends JpaRepository<Likes, Long>{
    /*JpaRepository will have all the functions of CrudRepository and PagingAndSortingRepository. So if you don't need
     the repository to have the functions provided by JpaRepository and PagingAndSortingRepository , use CrudRepository.*/

    //List<Like> findByAuthor(Long idPost);

    @Query("SELECT l FROM Likes l WHERE l.post = :post AND l.author = :author")
    List<Likes> findByPost(Post post, User author);

    @Transactional
    @Query("DELETE FROM Likes l WHERE l.post = :post AND l.author = :author")
    List<Likes> delete(Post post, User author);

    @Query("SELECT l FROM Likes l ORDER BY l.post.id ASC")
    List<Likes> findAll();

}
