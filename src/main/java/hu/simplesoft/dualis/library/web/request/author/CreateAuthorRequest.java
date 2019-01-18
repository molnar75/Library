package hu.simplesoft.dualis.library.web.request.author;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

@Validated
public class CreateAuthorRequest {

    @NotBlank
    private String name;
    
    @NotBlank
    private Date birthDate;
 
    public CreateAuthorRequest() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }
   
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
}
