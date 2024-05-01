package com.example.newsku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getNews();
    }

    void getNews(){
        NewsApiClient newsApiClient = new NewsApiClient("a8840dc95d4b4eb781c936a6221fba2a");
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .language("id")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        response.getArticles().forEach((a)-> {
                            Log.i("Article", a.getTitle());
                        });
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Log.i("GAGAL RESPOND", Objects.requireNonNull(throwable.getMessage()));
                    }
                }
        );
    }

}