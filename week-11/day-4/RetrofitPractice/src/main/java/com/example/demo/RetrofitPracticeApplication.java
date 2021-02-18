package com.example.demo;

import com.example.demo.service.UserService;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@SpringBootApplication
public class RetrofitPracticeApplication {

    public static void main(String[] args) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        UserService service = retrofit.create(UserService.class);
        // Using GitHubServiceGenerator
        service = GitHubServiceGenerator.createService(UserService.class);
        Call<User> callSync = service.getUser("eugenp");
        Call<User> callAsync = service.getUser("eugenp");

        try {
            Response<User> response = callSync.execute();
            User user = response.body();
//            System.out.println(user);
        } catch (IOException ex) {
        }

        // Execute the call asynchronously. Get a positive or negative callback.
        callAsync.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
//                System.out.println(user);
            }

            @Override
            public void onFailure(Call<User> call, Throwable throwable) {
                System.out.println(throwable);
            }
        });



        SpringApplication.run(RetrofitPracticeApplication.class, args);
    }


}
