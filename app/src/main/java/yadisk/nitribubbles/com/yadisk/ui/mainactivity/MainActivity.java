package yadisk.nitribubbles.com.yadisk.ui.mainactivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import dagger.Provides;
import yadisk.nitribubbles.com.yadisk.R;
import yadisk.nitribubbles.com.yadisk.core.BaseAppication;
import yadisk.nitribubbles.com.yadisk.core.MainModule;
import yadisk.nitribubbles.com.yadisk.core.Scopes;
import yadisk.nitribubbles.com.yadisk.data.repository.Repository;
import yadisk.nitribubbles.com.yadisk.data.store.LocalStorage;
import yadisk.nitribubbles.com.yadisk.ui.browserFragment.BrowserFragment;

import static yadisk.nitribubbles.com.yadisk.core.Constants.AUTH_URL;
import static yadisk.nitribubbles.com.yadisk.core.Constants.TOKEN;
import static yadisk.nitribubbles.com.yadisk.core.Constants.USERNAME;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    @Inject MainActivityPresenter presenter;

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }
        presenter.bindView(this);

        if (getIntent() != null && getIntent().getData() != null) {
            presenter.obtainToken(getIntent());
            setIntent(null);
        }

        presenter.launch(savedInstanceState);
    }

    void inject() {
        BaseAppication.Component appComponent = ((BaseAppication)getApplicationContext()).appComponent;
        MainActivity.Component component = DaggerMainActivity_Component.builder().module(new MainActivity.Module()).component(appComponent).build();
        component.inject(this);
    }

    @Override
    public void startLogin() {
        new AuthDialogFragment().show(getSupportFragmentManager(), "auth");
    }

    @Override
    public void showBrowserFragment() {
        Log.e("Tag", "MainActivity -> showBrowserFragment()");
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.show();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_container, new BrowserFragment())
                .commit();
    }

    public static class AuthDialogFragment extends DialogFragment {

        public AuthDialogFragment () {
            super();
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new android.app.AlertDialog.Builder(getActivity())
                    .setTitle("Авторизация")
                    .setMessage("Для продолжения работы требуется авторизация")
                    .setPositiveButton("Авторизоваться", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick (DialogInterface dialog, int which) {
                            dialog.dismiss();
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(AUTH_URL)));
                            getActivity().finish();
                        }
                    })
                    .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick (DialogInterface dialog, int which) {
                            dialog.dismiss();
                            getActivity().finish();
                        }
                    })
                    .create();
        }
    }

    @Scopes.PerActivity
    @dagger.Component(
            modules = {MainActivity.Module.class},
            dependencies = {BaseAppication.Component.class}
    )
    interface Component extends BaseAppication.Component {
        void inject(MainActivity activity);
        MainActivityPresenter presenter();
    }

    @dagger.Module
    class Module
    {
        @Scopes.PerActivity
        @Provides
        MainActivityPresenter providePresenter (Repository repository){
        return new MainActivityPresenter(repository);
    }
    }

}
