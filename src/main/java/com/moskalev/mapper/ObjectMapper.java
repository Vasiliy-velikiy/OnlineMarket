package com.moskalev.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface ObjectMapper<IN, OUT>  {
    OUT convert(IN obj);
   default List<OUT> convertList(List<IN> objList){
        return objList.stream().map(this::convert).collect(Collectors.toList());
    }
    Class<IN> getInClass();
    Class<OUT> getOutClass();

}
