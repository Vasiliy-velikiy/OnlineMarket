package com.moskalev.mapper;


import com.moskalev.entities.Provider;
import org.mapstruct.*;
import org.mapstruct.Mapper;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 24.02.22
 * Class mapper for conversion Provider to ProviderToUpdateDto and ProviderToCreateDto and back
 */
@Mapper
public interface MergeProviderMapper {

    /**
     * @param target        -Entity for merge
     * @param source-merged object
     * @return -new Object
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Provider merge(@MappingTarget  Provider target,  Provider source);
}
