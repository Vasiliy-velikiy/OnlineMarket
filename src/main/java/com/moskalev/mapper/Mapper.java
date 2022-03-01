package com.moskalev.mapper;

import java.util.List;

/**
 * @author Vasiliy Moskalev
 * @version 1.1
 * @since 24.02.22
 * Interface mapper for conversion Object and List Of Object
 */
public interface Mapper<IN, OUT> {

    OUT toDto(IN source);


    IN fromDto(OUT source);

    List<OUT> convertListToDto(List<IN> objList);
}
