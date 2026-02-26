package com.vlc2.academy.library.utility;

import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

public class GeneralUtility {

    public static <T> T getValueOfAnOptional (Optional<T> object, String classname, String field, Object value){

        if(object.isPresent()){
            return object.get();
        }
        else{
            throw new EntityNotFoundException(String.format("There's no %s with %s: '%s'",
                    classname, field, value));
        }
    }

}
