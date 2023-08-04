package tests.Api;


import com.github.javafaker.Faker;
import com.google.gson.Gson;
import my.project.Api.JobDto;
import okhttp3.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class JobControllerTest {

    private static final String BASE_URL = "https://freelance.lsrv.in.ua/api/job/";
    private final OkHttpClient httpClient = new OkHttpClient();
    private final Faker faker = new Faker();

    @BeforeClass
    public void setup() {
    }

    @Test
    public void testCreateJob() throws IOException {

        JobDto jobDto = new JobDto();
        jobDto.setTitle(faker.job().title());
        jobDto.setDescription(faker.lorem().sentence());
        jobDto.setPrice(faker.number().randomDouble(2, 10, 100));


        Gson gson = new Gson();
        String requestBody = gson.toJson(jobDto);

        RequestBody body = RequestBody.create(requestBody, MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .post(body)
                .url(BASE_URL + "/create")
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            int statusCode = response.code();
            String responseBody = response.body().string();

            System.out.println("Response Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);
        }
    }

    @Test
    public void testGetJobById() throws IOException {

        String jobId = "your_job_id_here";

        Request request = new Request.Builder()
                .get()
                .url(BASE_URL + "/" + jobId)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            int statusCode = response.code();
            String responseBody = response.body().string();


            System.out.println("Response Code: " + statusCode);
            System.out.println("Response Body: " + responseBody);
        }
    }

}