package yadisk.nitribubbles.com.yadisk.data.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import yadisk.nitribubbles.com.yadisk.core.Constants;
import yadisk.nitribubbles.com.yadisk.data.api.dto.response.DirectoryDto;
import yadisk.nitribubbles.com.yadisk.data.store.LocalStorage;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class API {
    private final LocalStorage localStorage;
    private final YandexApi yandexApi;

    public API(LocalStorage localStorage) {
        this.localStorage = localStorage;

        final OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        Gson gson = new GsonBuilder()
                .create();

        final Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(Constants.HOST)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        yandexApi = restAdapter.create(YandexApi.class);
    }

    public Observable<DirectoryDto> getResources(int offset, int limit, String dir){
        return yandexApi.getResources(localStorage.getToken(),"name", offset,limit,dir);
    }
}
