package com.moskalev.mapper;




import com.moskalev.dto.providerDto.ProviderToCreateDto;
import com.moskalev.dto.providerDto.ProviderToUpdateDto;
import com.moskalev.entities.Provider;
import org.mapstruct.*;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 24.02.22
 * Class mapper for conversion Provider to ProviderToUpdateDto and ProviderToCreateDto and back
 */
@Mapper
public interface ProviderMapper {

    /**
     * @param source -PersonToCreateDto object
     * @return Provider object
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productsOfProvider", ignore = true)
    Provider fromDto(ProviderToCreateDto source);

    /**
     * @param source -ProductToUpdateDto object
     * @return Provider object
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productsOfProvider", ignore = true)
    Provider fromUpdateDto(ProviderToUpdateDto source);

    /**
     * @param source -object that will merge
     * @param target -target object
     * @return new Provider object
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Provider merge(@MappingTarget  Provider target,  Provider source);
}
