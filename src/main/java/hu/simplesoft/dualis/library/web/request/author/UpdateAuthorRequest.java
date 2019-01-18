package hu.simplesoft.dualis.library.web.request.author;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

@Validated
public class UpdateAuthorRequest {

    @NotNull
    private long id;
    
    @NotBlank
    private String name;
    
    @NotBlank
    private Date birthDate;
    
    public UpdateAuthorRequest() {
    }
  
    public long getId() {
        return id;
    }
  
    public void setId(long id) {
        this.id = id;
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
