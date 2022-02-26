package com.moskalev.mapper;


import com.moskalev.dto.Impl.ProductToCreateDto;
import com.moskalev.dto.Impl.ProductToUpdateDto;
import com.moskalev.entities.Product;
import org.mapstruct.*;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 24.02.22
 * Class mapper for conversion Product to ProductToUpdateDto and ProductToCreateDto and back
 */
@Mapper
public interface ProductMapper {

    /**
     * @param source -PersonToCreateDto object
     * @return Product object
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "provider", ignore = true)
    @Mapping(target = "order", ignore = true)
    Product fromDto(ProductToCreateDto source);

    /**
     * @param source -ProductToUpdateDto object
     * @return Person object
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "provider", ignore = true)
    @Mapping(target = "order", ignore = true)
    Product fromUpdateDto(ProductToUpdateDto source);

    /**
     * @param source -object that will merge
     * @param target -target object
     * @return new Product object
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Product merge(@MappingTarget Product target, Product source);
}
