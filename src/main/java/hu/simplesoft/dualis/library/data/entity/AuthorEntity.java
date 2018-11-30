package hu.simplesoft.dualis.library.data.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity(name = "Authors")
@Table(name = "authors")
public class AuthorEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private long id;
    
    @NonNull
    @Column(name = "Name")
    private String name;
    
    @NonNull
    @Column(name = "Birth_date")
    private Date birthDate;

    
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
