package yadisk.nitribubbles.com.yadisk.data.repository;

import rx.Observable;
import yadisk.nitribubbles.com.yadisk.data.api.dto.response.DirectoryDto;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public interface Repository {
    void saveToken(String token);
    String getToken();

    Observable<DirectoryDto> loadDirectory(String dir);
}
