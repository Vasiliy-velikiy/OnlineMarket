package com.moskalev.mapper;

import com.moskalev.entities.Order;
import org.mapstruct.*;
import org.mapstruct.Mapper;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 09.02.22
 * Class mapper for conversion Order to OrderDto, OneProductToAddInOrderDto,ListOfProductsDto  and back
 */
@Mapper
public interface MergeOrderMapper {

    /**
     * @param target        -Entity for merge
     * @param source-merged object
     * @return -new Object
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order merge(@MappingTarget Order target, Order source);
}
