package ua.goit.module13.Task1;

import com.google.gson.Gson;
import ua.goit.module13.Task1.User;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpUtil {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";


    public static User createNewUser(User user) throws IOException, InterruptedException, URISyntaxException {
        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder(new URI(BASE_URL))
                .header("content-type", "application/json; charset=utf-8")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User.class);
    }
    public static User updateUser(User user) throws IOException, InterruptedException, URISyntaxException {
        final String requestBody = GSON.toJson(user);
        HttpRequest request = HttpRequest.newBuilder(new URI(BASE_URL + "/" + user.getId()))
                .header("content-type", "application/json; charset=utf-8")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User.class);
    }

    public static void deleteUser(int userId) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder(new URI(BASE_URL + "/" + userId))
                .DELETE()
                .build();
        HttpResponse<Void> response = CLIENT.send(request, HttpResponse.BodyHandlers.discarding());
        System.out.print(response.statusCode() + "\n");
    }

    public static User[] getAllUsers() throws IOException, InterruptedException, URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder(new URI(BASE_URL))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User[].class);
    }

    public static User getUserById(int userId) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder(new URI(BASE_URL + "/" + userId))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User.class);
    }

    public static void PostToFile() {

    }

    public static User getUserByUserName (String userName) throws IOException, InterruptedException, URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder(new URI(BASE_URL + "?username=" + userName))
                .GET()
                .build();
        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        User[] users = GSON.fromJson(response.body(), User[].class);
        if (users.length > 0) {
            return users[0];
        } else {
            return null;
        }
    }
}
