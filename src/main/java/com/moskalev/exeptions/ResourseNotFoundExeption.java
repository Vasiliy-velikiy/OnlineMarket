package com.moskalev.exeptions;
/**@version  1.1
 * @author Vasiliy Moskalev
 * Class runtimeexeption if some kind of resource not found */
public class ResourseNotFoundExeption extends  RuntimeException {

    public ResourseNotFoundExeption(String message) {
        super(message);
    }
}
