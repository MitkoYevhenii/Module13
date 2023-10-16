package ua.goit.module13.Task1;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        User user = createDefaultUser();


        User newUser = HttpUtil.createNewUser(user);
        System.out.println("newUser: " + newUser);

        User updateUser = HttpUtil.updateUser(user);
        System.out.println("updateUser: " + updateUser);

        System.out.print("Delte user result: ");
        HttpUtil.deleteUser(2);

        System.out.println("all users: ");
        User[] allUser = HttpUtil.getAllUsers();
        for (User thisUser : allUser) {
            System.out.println(thisUser);
        }

        User userById = HttpUtil.getUserById(1);
        System.out.println("userById: " + userById);

        User userByUserName = HttpUtil.getUserByUserName("Bret");
        System.out.println("userByUserName: " + userByUserName);
    }

    private static User createDefaultUser() {
        User.Address.Geo geo = new User.Address.Geo("40.7128", "-74.0060");
        User.Address address = new User.Address("123 Main St", "Apt 4B", "New York", "10001", geo);
        User.Company company = new User.Company("ABC Inc", "Delivering Excellence", "Innovative Solutions");
        User user = new User(1L, "John Doe", "johndoe", "johndoe@example.com", address, "123-456-7890", "www.johndoe.com", company);
        return user;
    }
}
