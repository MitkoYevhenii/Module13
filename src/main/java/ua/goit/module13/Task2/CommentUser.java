package ua.goit.module13.Task2;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentUser {
    private Long postId;
    private Long id;
    private String name;
    private String email;
    private String body;

    public CommentUser() {}
}
