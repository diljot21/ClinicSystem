
package com.sheridan.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author DILJOT
 */
public class User {

    private String username;
    private int role;
    private String password;
    
    public User() {
        
    }

    public User(String username, int role, String password) {
        this.username = username;
        this.role = role;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
