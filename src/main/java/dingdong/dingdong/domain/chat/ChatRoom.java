package dingdong.dingdong.domain.chat;

import dingdong.dingdong.domain.post.Post;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoom {

    @Id
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private Post post;

    private LocalDateTime endDate;

    private LocalDateTime lastChatTime;

    private String lastChatMessage;

    @OneToMany(mappedBy = "chatRoom")
    private List<ChatMessage> messages = new ArrayList<>();

    public ChatRoom(Post post) {
        this.id = post.getId();
        this.post = post;
    }
}