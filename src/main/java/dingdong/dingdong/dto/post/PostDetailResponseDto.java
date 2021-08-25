package dingdong.dingdong.dto.post;

import dingdong.dingdong.domain.post.Post;
import dingdong.dingdong.domain.user.Profile;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
public class PostDetailResponseDto {

    @NotNull
    private String title;

    @NotNull
    private String nickname;

    @NotNull
    private String profile_bio;

    @NotNull
    private Number good;

    @NotNull
    private Number bad;

    @NotNull
    private int cost;

    @NotNull
    private String bio;

    @NotNull
    private String local;

    @NotNull
    private LocalDateTime createdDate;

    @NotNull
    private LocalDateTime modifiedDate;

    @NotNull
    private int people;

    @NotNull
    private int gatheredPeople;

    private String imageUrl1;

    private String imageUrl2;

    private String imageUrl3;

    public PostDetailResponseDto(Post post, Profile profile){
        this.title = post.getTitle();
        this.cost = post.getCost();
        this.bio = post.getBio();
        this.imageUrl1 = post.getImageUrl1();
        this.imageUrl2 = post.getImageUrl2();
        this.imageUrl3 = post.getImageUrl3();
        this.createdDate = post.getCreatedDate();
        this.modifiedDate = post.getModifiedDate();
        this.people = post.getPeople();
        this.gatheredPeople = post.getGatheredPeople();
        this.local = post.getLocal();
        this.nickname = profile.getNickname();
        this.profile_bio = profile.getProfile_bio();
        this.good = profile.getGood();
        this.bad = profile.getBad();
    }
}
