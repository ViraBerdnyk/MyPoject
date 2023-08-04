package tests.Api;


import com.github.javafaker.Faker;
import com.google.gson.Gson;
import my.project.Api.SignUpRequest;
import okhttp3.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class AuthControllerTest {

    private static final String BASE_URL = "https://freelance.lsrv.in.ua";
    private final OkHttpClient httpClient = new OkHttpClient();
    private final Faker faker = new Faker();

    @BeforeClass
    public void setup() {

    }

    @Test
    public void testSignUp() throws IOException {
        SignUpRequest signUpRequest = new SignUpRequest(faker.name().username(), faker.internet().password());
        String requestBody = new Gson().toJson(signUpRequest);

        RequestBody body = RequestBody.create(requestBody, MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(BASE_URL + "/api/auth/signup")
                .post(body)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            int statusCode = response.code();
            String responseBody = response.body().string();

            System.out.println("Response Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);
        }
    }
}