package yadisk.nitribubbles.com.yadisk.data.api;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;
import yadisk.nitribubbles.com.yadisk.data.api.dto.response.DirectoryDto;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public interface YandexApi {
    @GET("v1/disk/resources")
    Observable<DirectoryDto> getResources(@Header("Authorization")String token,
                                          @Query("sort") String sort,
                                          @Query("offset") int offset,
                                          @Query("limit") int limit,
                                          @Query("path") String path);
}
