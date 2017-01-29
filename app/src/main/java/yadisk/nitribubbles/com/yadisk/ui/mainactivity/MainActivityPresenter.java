package yadisk.nitribubbles.com.yadisk.ui.mainactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import yadisk.nitribubbles.com.yadisk.data.repository.Repository;
import yadisk.nitribubbles.com.yadisk.ui.BasePresenter;


/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class MainActivityPresenter extends BasePresenter<MainActivityContract.View> implements MainActivityContract.Presenter {

    private final Repository repository;

    public MainActivityPresenter(Repository repository) {
        this.repository = repository;
    }

    private void saveToken(String token) {
        repository.saveToken(token);
    }

    @Override
    public void obtainToken(Intent intent) {
        Uri data = intent.getData();
        Pattern pattern = Pattern.compile("access_token=(.*?)(&|$)");
        Matcher matcher = pattern.matcher(data.toString());
        if (matcher.find()) {
            final String token = matcher.group(1);
            if (!TextUtils.isEmpty(token)) {
                saveToken(token);
            } else {
            }
        } else {
        }
    }

    @Override
    public void launch(Bundle bundle) {
        String token = repository.getToken();
        if (token == null) {
            getView().startLogin();
            return;
        }

        getView().showBrowserFragment();
    }
}
