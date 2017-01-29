package yadisk.nitribubbles.com.yadisk.data.repository;

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
}
