package yadisk.nitribubbles.com.yadisk.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import kotlin.annotation.AnnotationRetention;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class Scopes {
    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PerFragment {
    }

    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PerActivity {
    }

}
