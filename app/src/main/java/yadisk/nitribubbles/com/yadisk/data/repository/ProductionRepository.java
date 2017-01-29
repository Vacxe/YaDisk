package yadisk.nitribubbles.com.yadisk.data.repository;

import android.util.Log;

import rx.Observable;
import yadisk.nitribubbles.com.yadisk.data.api.API;
import yadisk.nitribubbles.com.yadisk.data.api.dto.response.DirectoryDto;
import yadisk.nitribubbles.com.yadisk.data.store.LocalStorage;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class ProductionRepository implements Repository {
    private final LocalStorage localStorage;
    private final API api;


    public ProductionRepository(LocalStorage localStorage, API api) {
        this.localStorage = localStorage;
        this.api = api;
    }

    @Override
    public void saveToken(String token) {
        localStorage.saveToken(token);
    }

    @Override
    public String getToken() {
        return localStorage.getToken();
    }

    @Override
    public Observable<DirectoryDto> loadDirectory(String dir) {
        Log.e("Tag", "ProductionRepository -> loadDirectory()");
        return api.getResources(0, 1000, dir);
    }
}
