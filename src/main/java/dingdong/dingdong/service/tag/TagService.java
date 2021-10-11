package dingdong.dingdong.service.tag;

import static dingdong.dingdong.util.exception.ResultCode.POST_NOT_FOUND;

import dingdong.dingdong.domain.post.Post;
import dingdong.dingdong.domain.post.PostRepository;
import dingdong.dingdong.domain.post.PostTag;
import dingdong.dingdong.domain.post.PostTagRepository;
import dingdong.dingdong.domain.post.Tag;
import dingdong.dingdong.domain.post.TagRepository;
import dingdong.dingdong.dto.tag.TagRequestDto;
import dingdong.dingdong.util.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TagService {

    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final PostTagRepository postTagRepository;

    @Transactional
    public void addTags(Long id, TagRequestDto tagRequestDto) {
        PostTag postTag = new PostTag();
        Post post = postRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(POST_NOT_FOUND));

        if (!tagRepository.existsByName(tagRequestDto.getName())) {
            Tag tag = new Tag();
            tag.setName(tagRequestDto.getName());
            tagRepository.save(tag);
        }

        Tag tag = tagRepository.findByName(tagRequestDto.getName());

        postTag.setTag(tag);
        postTag.setPost(post);
        postTagRepository.save(postTag);
    }
}
