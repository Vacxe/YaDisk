package yadisk.nitribubbles.com.yadisk.ui;

import com.google.common.eventbus.Subscribe;

import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public abstract class BasePresenter<T> {
    T view;
    CompositeSubscription subscription;
    public void bindView(T view){
        this.view = view;
        subscription = new CompositeSubscription();
    }

    public void unbindView(){
        view = null;
    }

    public T getView(){
        return view;
    }

    public void addSubscriber(Subscriber subscriber){
        subscription.add(subscriber);
    }
}
