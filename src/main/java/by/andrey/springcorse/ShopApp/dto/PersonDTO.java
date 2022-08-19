package by.andrey.springcorse.ShopApp.dto;

import by.andrey.springcorse.ShopApp.models.Person;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;


public class PersonDTO {                //слоя между сущностью и контроллером

    @Size(min = 3, max = 25)
    private String name;

    @Size(min = 3, max = 50)
    private String email;

    @Size(min = 3, max = 25)
    private String phone;

    private LocalDateTime registration;


    public LocalDateTime getRegistration() {
        return registration;
    }

    public void setRegistration(LocalDateTime registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}