package yadisk.nitribubbles.com.yadisk.ui;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public abstract class BasePresenter<T> {
    T view;
    public void bindView(T view){
        this.view = view;
    }

    public void unbindView(){
        view = null;
    }

    public T getView(){
        return view;
    }
}
