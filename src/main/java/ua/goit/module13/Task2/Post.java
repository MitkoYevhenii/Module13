package ua.goit.module13.Task2;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Post {
    private Long postId;
    private Long id;
    private String name;
    private String email;
    private String body;

    public Post(Long postId, Long id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }
}

