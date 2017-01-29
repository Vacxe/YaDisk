package yadisk.nitribubbles.com.yadisk.data.api.dto.response;

import java.util.ArrayList;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class ResourceContentDto {
    ArrayList<ResourceDto> items;

    public ArrayList<ResourceDto> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "ResourceContent{" +
                "items=" + items +
                '}';
    }
}
