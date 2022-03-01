package com.moskalev.mapper;


import com.moskalev.entities.Product;
import org.mapstruct.*;
import org.mapstruct.Mapper;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 24.02.22
 * Class mapper for conversion Product to ProductToUpdateDto and ProductToCreateDto and back
 */
@Mapper
public interface MergeProductMapper {

    /**
     * @param target        -Entity for merge
     * @param source-merged object
     * @return -new Object
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product merge(@MappingTarget Product target, Product source);
}
