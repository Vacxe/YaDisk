package yadisk.nitribubbles.com.yadisk.data.repository;

import rx.Observable;
import yadisk.nitribubbles.com.yadisk.data.api.dto.response.DirectoryDto;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class TestRepository implements Repository  {
    @Override
    public void saveToken(String token) {

    }

    @Override
    public String getToken() {
        return "testToken";
    }

    @Override
    public Observable<DirectoryDto> loadDirectory(String dir) {
        return null;
    }
}
