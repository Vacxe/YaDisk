package yadisk.nitribubbles.com.yadisk.ui.browserFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.Provides;
import yadisk.nitribubbles.com.yadisk.R;
import yadisk.nitribubbles.com.yadisk.core.BaseAppication;
import yadisk.nitribubbles.com.yadisk.core.Scopes;
import yadisk.nitribubbles.com.yadisk.data.repository.Repository;
import yadisk.nitribubbles.com.yadisk.databinding.BrowserFragmentLayoutBinding;
import yadisk.nitribubbles.com.yadisk.ui.browserFragment.adapter.ResourcesListAdapter;
import yadisk.nitribubbles.com.yadisk.ui.object.Directory;
import yadisk.nitribubbles.com.yadisk.ui.object.Resource;

import static yadisk.nitribubbles.com.yadisk.core.Constants.ROOT;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class BrowserFragment extends Fragment implements BrowserFragmentContract.View, ResourcesListAdapter.OnItemClickListener{

    @Inject BrowserFragmentPresenter presenter;

    BrowserFragmentLayoutBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = BrowserFragmentLayoutBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inject();
        presenter.bindView(this);

        binding.backstackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadPreviousDirectory();
            }
        });

        presenter.loadDirectory(ROOT);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.unbindView();
    }

    void inject() {
        BaseAppication.Component appComponent = ((BaseAppication)getActivity().getApplicationContext()).appComponent;
        BrowserFragment.Component component = DaggerBrowserFragment_Component.builder().module(new BrowserFragment.Module()).component(appComponent).build();
        component.inject(this);
    }



    @Override
    public void showList(List<Resource> resources) {
        ResourcesListAdapter adapter = new ResourcesListAdapter(resources, this);
        binding.resourcesList.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.resourcesList.setAdapter(adapter);
        //TODO: reuse adapter
    }

    @Override
    public void showDirectory(Directory directory) {
        binding.dirName.setText(directory.getName());
        binding.dirPath.setText(getString(R.string.path) + directory.getPath());
        if(directory.getPath().equals(ROOT)){
            binding.backstackView.setClickable(false);
            binding.backstackView.setAlpha(.6f);
        }else {
            binding.backstackView.setClickable(true);
            binding.backstackView.setAlpha(1f);
        }

    }

    @Override
    public void showErrorMessage() {
        Context context = getContext();
        if(context != null){
            Toast.makeText(context, R.string.load_error, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showLoader() {

    }

    @Override
    public void hideLoader() {

    }

    @Override
    public void onClick(Resource resource) {
        switch (resource.getType()){
            case DIR:
                presenter.loadDirectory(resource.getPath());
                break;
            case FILE:
                presenter.openFile(resource);
                break;
        }
    }

    @Scopes.PerFragment
    @dagger.Component(
            modules = {BrowserFragment.Module.class},
            dependencies = {BaseAppication.Component.class}
    )
    interface Component extends BaseAppication.Component {
        void inject(BrowserFragment activity);
        BrowserFragmentPresenter presenter();
    }

    @dagger.Module
    class Module
    {
        @Scopes.PerFragment
        @Provides
        BrowserFragmentPresenter providePresenter (Repository repository){
            return new BrowserFragmentPresenter(repository);
        }
    }
}
