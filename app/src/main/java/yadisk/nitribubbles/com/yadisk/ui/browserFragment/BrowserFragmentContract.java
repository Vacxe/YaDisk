package yadisk.nitribubbles.com.yadisk.ui.browserFragment;

import java.util.ArrayList;
import java.util.List;

import yadisk.nitribubbles.com.yadisk.data.api.dto.response.DirectoryDto;
import yadisk.nitribubbles.com.yadisk.ui.object.Directory;
import yadisk.nitribubbles.com.yadisk.ui.object.Resource;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class BrowserFragmentContract {
    interface Presenter{
        void loadDirectory(String dir);

    }

    interface View{
        void showErrorMessage();
        void showDirectory(Directory directory);
        void showList(List<Resource> resources);
        void showLoader();
        void hideLoader();

    }
}
