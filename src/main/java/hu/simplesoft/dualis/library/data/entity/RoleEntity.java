package hu.simplesoft.dualis.library.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity(name = "Role")
@Table(name = "role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    
    @NonNull
    @Column(name = "Role")
    private String role;

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
  
    public String getRole() {
        return role;
    }
 
    public void setRole(String role) {
        this.role = role;
    }
    
}
