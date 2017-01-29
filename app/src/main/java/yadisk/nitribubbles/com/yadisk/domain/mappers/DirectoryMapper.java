package yadisk.nitribubbles.com.yadisk.domain.mappers;

import rx.functions.Func1;
import yadisk.nitribubbles.com.yadisk.data.api.dto.response.DirectoryDto;
import yadisk.nitribubbles.com.yadisk.ui.object.Directory;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class DirectoryMapper implements Func1<DirectoryDto, Directory> {
    @Override
    public Directory call(DirectoryDto directoryDto) {
        return new Directory(directoryDto.getContent(), directoryDto.getName(), directoryDto.getPath());
    }
}
