package hu.simplesoft.dualis.library.web.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

@Validated
public class IdRequest {
    
    public IdRequest() {
    }
   
    @NotNull
    @Min(value = 1)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
