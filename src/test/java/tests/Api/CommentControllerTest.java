package tests.Api;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import my.project.Api.CommentDto;
import okhttp3.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class CommentControllerTest {

    private static final String BASE_URL = "https://freelance.lsrv.in.ua";
    private final OkHttpClient httpClient = new OkHttpClient();
    private final Faker faker = new Faker();

    @BeforeClass
    public void setup() {
    }

    @Test
    public void testCreateComment() throws IOException {
        CommentDto commentDto = new CommentDto();
        commentDto.setMessage(faker.lorem().sentence());

        Gson gson = new Gson();
        String requestBody = gson.toJson(commentDto);

        RequestBody body = RequestBody.create(requestBody, MediaType.parse("application/json"));

        String jobId = "your_job_id";
        Request request = new Request.Builder()
                .post(body)
                .url(BASE_URL + "/api/comment/" + jobId + "/create")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            int statusCode = response.code();

        }
    }
}