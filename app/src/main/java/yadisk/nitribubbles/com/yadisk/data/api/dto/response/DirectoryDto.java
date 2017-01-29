package yadisk.nitribubbles.com.yadisk.data.api.dto.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class DirectoryDto {
    @SerializedName("_embedded")
    ResourceContentDto content;
    String name;
    String path;
    String created;
    String modified;
    FileType type;
    Long revision;

    public ResourceContentDto getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public String getCreated() {
        return created;
    }

    public String getModified() {
        return modified;
    }

    public FileType getType() {
        return type;
    }

    public Long getRevision() {
        return revision;
    }

    public String getPath() {
        return path.replace("disk:", "");
    }

    @Override
    public String toString() {
        return "Directory{" +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", created='" + created + '\'' +
                ", modified='" + modified + '\'' +
                ", type=" + type +
                ", revision=" + revision +
                '}';
    }
}

