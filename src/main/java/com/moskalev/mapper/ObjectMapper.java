package com.moskalev.mapper;

import java.util.List;
import java.util.stream.Collectors;

/**@version  1.1
 * @author Vasiliy Moskalev
 *@since 08.02.22
 * interface for Mapper which have common coverting method to list*/
public interface ObjectMapper<IN, OUT>  {
    /**@param obj inner class
     * @return outer class*/
    OUT convert(IN obj);


    /**@param objList same objects and convert they
     * @return new list converted objects*/
   default List<OUT> convertList(List<IN> objList){
        return objList.stream().map(this::convert).collect(Collectors.toList());
    }

    /**@return name inner class*/
    Class<IN> getInClass();

    /**@return name outer class*/
    Class<OUT> getOutClass();

}
