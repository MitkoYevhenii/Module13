package ua.goit.module13.Task2;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostUser {
    private Long userId;
    private Long id;
    private String title;
    private String body;

    public PostUser(Long userId) {

    }
}
