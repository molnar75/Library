package hu.simplesoft.dualis.library.service.dto;

import java.util.Date;

public class AuthorDto {
    
    private long id;
    private String name;
    private Date birthDate;
    
    public AuthorDto() {
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
