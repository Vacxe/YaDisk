package yadisk.nitribubbles.com.yadisk.domain.interactors;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public interface Interactor<T, R> {
    void execute();
    void updateParameter(T parameter);
    void unsubsribe();

}
