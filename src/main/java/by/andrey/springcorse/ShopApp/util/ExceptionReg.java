package by.andrey.springcorse.ShopApp.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@Component
public class ExceptionReg {

    public NotCreatedException except(BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error: errors) {
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append("; ");
            }
            throw new NotCreatedException(errorMsg.toString());
        }
        else return null;
    }


}
