package com.movieplatform.userservice.constants;

import lombok.Getter;

/**
 * @author Kayhan Öztürk
 * @version 0.1
 * @since 0.1
 */
public enum ExceptionParameter {
    USER_SERVICE_NOT_FOUND("USER_SERVICE_NOT_FOUND");
    @Getter
    private String key;

     ExceptionParameter(String key){
        this.key = key;
    }

    public static String getByKod(String key){
         for(ExceptionParameter parameter : ExceptionParameter.values()){
             if(parameter.getKey().equals(key)){
                 return parameter.getKey();
             }
         }
         return null;
    }
}
