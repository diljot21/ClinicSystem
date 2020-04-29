
package com.sheridan.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author DILJOT
 */
public class Doctor extends User{

    private int CPSO;
    private String firstName;
    private String middleInitials;
    private String lastName;
    private String login;
    private int practiceAddress;
    private String practiceName;

    public Doctor() {
        
    }

    public Doctor(String username, int role, String password, 
            int CPSO, String firstName, String middleInitials, String lastName, 
            String login, int practiceAddress, String practiceName) {
        super(username, role, password);
        this.CPSO = CPSO;
        this.firstName = firstName;
        this.middleInitials = middleInitials;
        this.lastName = lastName;
        this.login = login;
        this.practiceAddress = practiceAddress;
        this.practiceName = practiceName;
    }

    public int getCPSO() {
        return CPSO;
    }

    public void setCPSO(int CPSO) {
        this.CPSO = CPSO;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitials() {
        return middleInitials;
    }

    public void setMiddleInitials(String middleInitials) {
        this.middleInitials = middleInitials;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPracticeAddress() {
        return practiceAddress;
    }

    public void setPracticeAddress(int practiceAddress) {
        this.practiceAddress = practiceAddress;
    }

    public String getPracticeName() {
        return practiceName;
    }

    public void setPracticeName(String practiceName) {
        this.practiceName = practiceName;
    }
}
