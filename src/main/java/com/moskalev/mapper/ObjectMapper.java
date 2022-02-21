package com.moskalev.mapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vasiliy  Moskalev
 * @version 1.1
 * @since 08.02.22
 * interface for Mapper which have common converting method to list
 */
public interface ObjectMapper<IN, OUT> {
    /**
     * @param obj inner class
     * @return outer class
     */
    OUT convertToDto(IN obj);

    /**
     * @param obj inner class
     * @return outer class
     */
    IN convertFromDto(OUT obj);


    /**
     * @param objList Clear objects and convert they
     * @return new list converted Dto objects
     */
    default List<OUT> convertListToDto(List<IN> objList) {
        return objList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * @param objList DTO objects and convert they
     * @return new list converted clear objects
     */
    default List<IN> convertListFromDto(List<OUT> objList) {
        return objList.stream().map(this::convertFromDto).collect(Collectors.toList());
    }

}
