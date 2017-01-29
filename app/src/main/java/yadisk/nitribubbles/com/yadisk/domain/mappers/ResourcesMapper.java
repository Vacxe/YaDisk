package yadisk.nitribubbles.com.yadisk.domain.mappers;

import rx.functions.Func1;
import yadisk.nitribubbles.com.yadisk.data.api.dto.response.ResourceDto;
import yadisk.nitribubbles.com.yadisk.ui.object.Resource;

/**
 * Created by konstantinaksenov on 29.01.17.
 */

public class ResourcesMapper implements Func1<ResourceDto, Resource> {
    @Override
    public Resource call(ResourceDto resourceDto) {
        return new Resource(
                resourceDto.getName(),
                resourceDto.getCreated(),
                resourceDto.getResourceId(),
                resourceDto.getModified(),
                resourceDto.getMedia_type(),
                resourceDto.getPath(),
                resourceDto.getMedia_type(),
                resourceDto.getType());
    }
}
