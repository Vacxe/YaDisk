package yadisk.nitribubbles.com.yadisk.data.repository;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public interface Repository {
    void saveToken(String token);
    String getToken();
}
