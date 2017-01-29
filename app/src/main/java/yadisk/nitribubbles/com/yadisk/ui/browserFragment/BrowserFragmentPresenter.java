package yadisk.nitribubbles.com.yadisk.ui.browserFragment;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import yadisk.nitribubbles.com.yadisk.data.api.dto.response.DirectoryDto;
import yadisk.nitribubbles.com.yadisk.data.repository.Repository;
import yadisk.nitribubbles.com.yadisk.domain.mappers.DirectoryMapper;
import yadisk.nitribubbles.com.yadisk.domain.mappers.ResourcesMapper;
import yadisk.nitribubbles.com.yadisk.ui.BasePresenter;
import yadisk.nitribubbles.com.yadisk.ui.object.Resource;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class BrowserFragmentPresenter extends BasePresenter<BrowserFragmentContract.View> implements BrowserFragmentContract.Presenter {

    private final Repository repository;
    private Subscription loadSubscription;

    DirectoryMapper directoryMapper = new DirectoryMapper();
    ResourcesMapper resourcesMapper = new ResourcesMapper();

    public BrowserFragmentPresenter(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void loadDirectory(String dir) {

        BrowserFragmentContract.View view = getView();
        if(view != null){
            view.showLoader();
        }
        Log.e("Tag", "BrowserFragmentPresenter -> loadDirectory()" + dir);
        if (loadSubscription != null && !loadSubscription.isUnsubscribed())
            loadSubscription.unsubscribe();

        loadSubscription = repository
                .loadDirectory(dir)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<DirectoryDto>() {
                    @Override
                    public void onCompleted() {
                        BrowserFragmentContract.View view = getView();
                        if(view != null){
                            view.hideLoader();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("Tag", e.getMessage());
                        BrowserFragmentContract.View view = getView();
                        if(view != null) {
                            view.showErrorMessage();
                            view.hideLoader();
                        }

                    }

                    @Override
                    public void onNext(DirectoryDto directory) {
                        final BrowserFragmentContract.View view = getView();
                        if(view != null) {
                            view.showDirectory(directoryMapper.call(directory));
                            Observable
                                    .from(directory.getContent().getItems())
                                    .map(resourcesMapper)
                                    .toList()
                                    .subscribe(new Action1<List<Resource>>() {
                                        @Override
                                        public void call(List<Resource> resources) {
                                            view.showList(resources);
                                        }
                                    });
                        }
                    }
                });
    }
}
