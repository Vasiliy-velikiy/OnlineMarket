package com.moskalev.mapper;

import com.moskalev.dto.Impl.PersonToCreateDto;
import com.moskalev.dto.Impl.PersonToUpdateDto;
import com.moskalev.entities.Person;
import org.mapstruct.*;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 09.02.22
 * Class mapper for conversion Person to PersonToUpdateDto and PersonToCreateDto and back
 */
@Mapper
public interface PersMapper {

//    /**
//     * @param source -PersonToCreateDto object
//     * @return Person object
//     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "basketForProductList", ignore = true)
    Person fromDto(PersonToCreateDto source);

//    /**
//     * @param source -PersonToUpdateDto object
//     * @return Person object
//     */
    @Mapping(target = "id", ignore = true)
  @Mapping(target = "basketForProductList", ignore = true)
   Person fromUpdateDto(PersonToUpdateDto source);

//    /**
//     * @param source -object that will merge
//     * @param target -target object
//     * @return new Person object
//     */

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Person merge(@MappingTarget Person target, Person source);
}
