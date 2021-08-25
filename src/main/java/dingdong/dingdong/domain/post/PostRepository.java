package dingdong.dingdong.domain.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // 홈화면 최신순 정렬
    @Query(value = "select * from post, user where post.user_id = user.user_id and (user.local1 = :local1 or user.local2 = :local2)",
            countQuery = "select count(*) from post",
            nativeQuery = true)
    Page<Post> findAllByCreateDate(Long local1,Long local2, Pageable pageable);

    // 홈화면 마감일자순 정렬
    @Query(value = "select * from post, user where post.user_id = user.user_id and (user.local1 = :local1 or user.local2 = :local2) " +
            "order by (post.gathered_people / post.people) desc",
            countQuery = "select count(*) from post",
            nativeQuery = true)
    Page<Post> findAllByEndDate(Long local1,Long local2, Pageable pageable);
    
    @Query(value = "select * from post, user where post.user_id = user.user_id and (user.local1 = :local1 or user.local2 = :local2) and post.category_id = :category_id",
            countQuery = "select count(*) from post",
            nativeQuery = true)
    Page<Post> findByCategoryId(Long local1, Long local2, Long category_id, Pageable pageable);

    Page<Post> findByUserId(Long UserId, Pageable pageable);

    @Query(value = "select * from post, user, category where post.user_id = user.user_id AND post.category_id = category.category_id AND" +
            "(post.title LIKE %:keyword% OR  category.name LIKE %:keyword%)AND (user.local1 = :local1 or user.local2 = :local2)",
            countQuery = "select count(*) from post",
            nativeQuery = true)
    Page<Post> findAllSearch(String keyword, Long local1,Long local2, Pageable pageable);
}
