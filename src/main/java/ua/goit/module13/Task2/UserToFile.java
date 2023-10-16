package ua.goit.module13.Task2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class UserToFile {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();
    private static final String FIRST_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String SECOND_URL = "https://jsonplaceholder.typicode.com/posts";

    public static void userToFile(Long userId) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest firstRequest = HttpRequest.newBuilder(new URI(FIRST_URL + "/" + userId + "/posts"))
                .GET()
                .build();
        HttpResponse<String> firstResponse = CLIENT.send(firstRequest, HttpResponse.BodyHandlers.ofString());
        User[] users =  GSON.fromJson(firstResponse.body(), User[].class);

        Long maxId = Arrays.stream(users)
                .max(Comparator.comparing(User::getId))
                .map(User::getId)
                .orElse(null);
        System.out.println(maxId);

        HttpRequest secondRequest = HttpRequest.newBuilder(new URI(SECOND_URL + "/" + maxId + "/comments"))
                .GET()
                .build();
        HttpResponse<String> secondResponse = CLIENT.send(secondRequest, HttpResponse.BodyHandlers.ofString());
        List<Post> posts = GSON.fromJson(secondResponse.body(), new TypeToken<List<Post>>() {}.getType());

        String fileName = "C:\\Users\\Zhenia\\Documents\\GoIT\\Module13\\src\\main\\java\\ua\\goit\\module13\\Task2\\" +
                "user-" + userId + "-post-" + maxId + "-comments.json";

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            GSON.toJson(posts, fileWriter);
        }
    }
}