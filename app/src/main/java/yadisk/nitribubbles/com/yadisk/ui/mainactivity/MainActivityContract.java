package yadisk.nitribubbles.com.yadisk.ui.mainactivity;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public interface MainActivityContract {
    interface Presenter{
        void obtainToken(Intent intent);
        void launch(Bundle bundle);
    }
    interface View{
        void startLogin();
        void showBrowserFragment();
    }
}
