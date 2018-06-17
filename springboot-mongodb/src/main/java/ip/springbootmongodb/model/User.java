package ip.springbootmongodb.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Document(collection= "Users")
public class User implements UserDetails {
///TODO  vezi celalalt
    public static enum Role{ USER }
    /**
     * Description of the property id.
     */

    @Id
    private String id;
    /**
     * Description of the property email.
     */
    private String username ;
    /**
     * Description of the property password.
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password ;
    /**
     * Description of the property role , to grant authority to the user .
     */
    private String  role;
    /**
     * Description of the property full name.
     */
    private String fullName;

    public User(){

    }

    public User(String username,String password,String fullName){
        this.username=username;
        this.password= password;
        this.fullName=fullName;
    }




    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role +
                ",]";
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }




}
