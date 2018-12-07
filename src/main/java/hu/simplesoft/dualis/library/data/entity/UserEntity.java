package hu.simplesoft.dualis.library.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity(name = "User")
@Table(name = "users")
public class UserEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private long id;

        @NonNull
        @Column(name = "Username")
        private String userName;
        
        @NonNull
        @Column(name = "Password")
        private String password;

        @NonNull
        @Column(name = "Email")
        private String email;
        
        @Column(name = "Name")
        private String name;
        
        @NonNull
        @Column(name = "Phone_number")
        private String phoneNumber;
        
        @OneToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "Role_id")
        private RoleEntity role;
        
        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "Address_id")
        private AddressEntity address;
        
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "Library_id")
        private LibraryEntity library;
                
        public long getId() {
            return id;
        }

        
        public void setId(long id) {
            this.id = id;
        }

        
        public String getUserName() {
            return userName;
        }

        
        public void setUserName(String userName) {
            this.userName = userName;
        }

        
        public String getPassword() {
            return password;
        }

        
        public void setPassword(String password) {
            this.password = password;
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

        
        public String getPhoneNumber() {
            return phoneNumber;
        }

        
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

 }

