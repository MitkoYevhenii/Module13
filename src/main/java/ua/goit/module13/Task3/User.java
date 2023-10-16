package ua.goit.module13.Task3;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class User {
    Long userId;
    Long id;
    String title;
    boolean completed;

    public User() {
        // Default constructor
    }

    public User(Long userId, Long id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
}


