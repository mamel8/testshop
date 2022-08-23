package by.andrey.springcorse.ShopApp.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class NotCreatedException extends RuntimeException{

    public NotCreatedException(String msg){
        super(msg);
    }


}
