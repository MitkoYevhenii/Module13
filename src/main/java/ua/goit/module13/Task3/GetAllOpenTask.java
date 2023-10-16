package ua.goit.module13.Task3;

import com.google.gson.Gson;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.val;

public class GetAllOpenTask {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @SneakyThrows
    public static List<User> getAllOpenTasks(User user) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(BASE_URL + "/" + user.getId() + "/todos"))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        List<User> userList = OBJECT_MAPPER.readValue(response.body(), new TypeReference<List<User>>() {
        });
        return userList
                .stream()
                .filter(task -> !task.isCompleted())
                .toList();
    }
}




