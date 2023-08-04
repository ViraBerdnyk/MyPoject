package tests.Api;



import com.github.javafaker.Faker;
import okhttp3.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserControllerTest {

    private static final String BASE_URL = "https://freelance.lsrv.in.ua/api/user/";
    private final OkHttpClient httpClient = new OkHttpClient();
    private final Faker faker = new Faker();

    @BeforeClass
    public void setup() {

    }

    @Test
    public void testUpdateUser() throws IOException {
    }

    @Test
    public void testGetUserById() throws IOException {
    }


    private String getAuthToken() {
        return "Authorization";

    }
}