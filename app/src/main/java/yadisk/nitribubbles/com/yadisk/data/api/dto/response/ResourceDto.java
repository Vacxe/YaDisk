package yadisk.nitribubbles.com.yadisk.data.api.dto.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class ResourceDto {
    String name;
    String created;
    @SerializedName("resource_id")
    String resourceId;
    String modified;
    String preview;
    String media_type;
    String path;
    String mime_type;
    String md5;
    int size;
    FileType type;

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

    public String getPreview() {
        return preview;
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

    public String getMd5() {
        return md5;
    }

    public int getSize() {
        return size;
    }

    public FileType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                ", created='" + created + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", modified='" + modified + '\'' +
                ", preview='" + preview + '\'' +
                ", media_type='" + media_type + '\'' +
                ", path='" + path + '\'' +
                ", mime_type='" + mime_type + '\'' +
                ", md5='" + md5 + '\'' +
                ", size=" + size +
                ", type=" + type +
                '}';
    }
}
