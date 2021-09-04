package dingdong.dingdong.domain.chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ChatPromiseRepository extends JpaRepository<ChatPromise, Long> {

//    @Query(value = "select * from chat_promise where post_id = :id", nativeQuery = true)
//    Optional<ChatPromise> findByPost_Id(Long id);

    Optional<ChatPromise> findByChatRoom(ChatRoom chatRoom);
    void deleteById(Long id);
}
