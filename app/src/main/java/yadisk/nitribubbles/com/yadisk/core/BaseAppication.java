package yadisk.nitribubbles.com.yadisk.core;

import android.app.Application;

import javax.inject.Singleton;

import yadisk.nitribubbles.com.yadisk.data.repository.Repository;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class BaseAppication extends Application {
    public Component appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = createComponent();
    }

   private Component createComponent(){
        return DaggerBaseAppication_Component.builder().mainModule(new MainModule(this)).build();
    }


    @Singleton
    @dagger.Component(modules = {MainModule.class})
    public interface Component{
        Repository repository();
    }
}
