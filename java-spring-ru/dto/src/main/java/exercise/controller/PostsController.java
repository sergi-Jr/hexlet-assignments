package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping(path = "")
    public List<PostDTO> index() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(p -> buildPostDTO(p, null))
                .toList();
    }

    @GetMapping(path = "/{id}")
    public PostDTO show(@PathVariable Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        List<Comment> comments = commentRepository.findByPostId(id);
        List<CommentDTO> commDto = comments.stream().map(this::buildCommentDTO).toList();
        return buildPostDTO(post, commDto);
    }

    private PostDTO buildPostDTO(Post post, List<CommentDTO> comments) {
        PostDTO dto = new PostDTO();
        dto.setBody(post.getBody());
        dto.setTitle(post.getTitle());
        dto.setId(post.getId());
        dto.setComments(comments);
        return dto;
    }

    private CommentDTO buildCommentDTO(Comment comment) {
        CommentDTO dto = new CommentDTO();
        dto.setBody(comment.getBody());
        dto.setId(comment.getId());
        return dto;
    }
}
// END
