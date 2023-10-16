package ua.goit.module13.Task2;

import com.google.gson.Gson;

import java.net.http.HttpClient;

public class UserToFile {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    public static void userToFile() {

    }

}
