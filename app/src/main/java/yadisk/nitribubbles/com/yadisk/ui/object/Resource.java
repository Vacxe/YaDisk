package yadisk.nitribubbles.com.yadisk.ui.object;

import com.google.gson.annotations.SerializedName;

import yadisk.nitribubbles.com.yadisk.data.api.dto.response.FileType;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class Resource {
    String name;
    String created;
    String resourceId;
    String modified;
    String media_type;
    String path;
    String mime_type;
    FileType type;

    public Resource(String name, String created, String resourceId, String modified, String media_type, String path, String mime_type, FileType type) {
        this.name = name;
        this.created = created;
        this.resourceId = resourceId;
        this.modified = modified;
        this.media_type = media_type;
        this.path = path;
        this.mime_type = mime_type;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getCreated() {
        return created;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getModified() {
        return modified;
    }

    public String getMedia_type() {
        return media_type;
    }

    public String getPath() {
        return path;
    }

    public String getMime_type() {
        return mime_type;
    }

    public FileType getType() {
        return type;
    }
}
