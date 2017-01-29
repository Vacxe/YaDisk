package yadisk.nitribubbles.com.yadisk.ui.object;

import com.google.gson.annotations.SerializedName;

import yadisk.nitribubbles.com.yadisk.data.api.dto.response.FileType;
import yadisk.nitribubbles.com.yadisk.data.api.dto.response.ResourceContentDto;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class Directory {
    ResourceContentDto content;
    String name;
    String path;

    public Directory(ResourceContentDto content, String name, String path) {
        this.content = content;
        this.name = name;
        this.path = path;
    }

    public ResourceContentDto getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }
}
