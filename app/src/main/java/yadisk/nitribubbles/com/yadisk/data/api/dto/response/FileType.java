package yadisk.nitribubbles.com.yadisk.data.api.dto.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public enum FileType {
    @SerializedName("dir")
    DIR,

    @SerializedName("file")
    FILE
}
