package my.project.Api;

import com.github.javafaker.Faker;
import lombok.Data;

import java.util.Random;

@Data
public class SignUpRequest {
    private String username;
    private String password;

    public SignUpRequest() {
        this(new Faker());
    }

    public SignUpRequest(Faker faker) {
        this.username = faker.name().username();
        this.password = generateRandomPassword(faker);
    }

    public SignUpRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String generateRandomPassword(Faker faker) {
        String password;
        do {
            password = faker.internet().password();
        } while (password.length() < 8);
        return password;
    }
}