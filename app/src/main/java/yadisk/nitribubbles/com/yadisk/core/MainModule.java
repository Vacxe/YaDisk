package yadisk.nitribubbles.com.yadisk.core;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Provides;
import yadisk.nitribubbles.com.yadisk.data.repository.ProductionRepository;
import yadisk.nitribubbles.com.yadisk.data.repository.Repository;
import yadisk.nitribubbles.com.yadisk.data.store.LocalStorage;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

@dagger.Module
public class MainModule {
    private final Application app;

    public MainModule(Application app) {
        this.app = app;
    }

    @Singleton
    @Provides
    public Repository provideRepository(LocalStorage localStorage){
        return new ProductionRepository(localStorage);
    }

    @Singleton
    @Provides
    public LocalStorage provideLocalStorage(){
        return new LocalStorage(app);
    }

}
