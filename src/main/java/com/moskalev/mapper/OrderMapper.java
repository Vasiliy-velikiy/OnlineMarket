package com.moskalev.mapper;

import com.moskalev.dto.orderDto.OrderDto;
import com.moskalev.entities.Order;
import org.mapstruct.*;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 09.02.22
 * Class mapper for conversion Person to PersonToUpdateDto and PersonToCreateDto and back
 */
@Mapper
public interface OrderMapper {

    /**
     * @param source -PersonToCreateDto object
     * @return Person object
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "products", ignore = true)
    @Mapping(target = "owner", ignore = true)
    Order fromDto(OrderDto source);

    /**
     * @param source -object that will merge
     * @param target -target object
     * @return new Person object
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Order merge(@MappingTarget Order target, Order source);
}
