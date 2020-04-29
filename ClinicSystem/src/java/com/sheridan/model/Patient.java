package com.sheridan.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author DILJOT
 */
public class Patient extends User{
    private long addressId;
    private String streetLine1;
    private String streetLine2;
    private String aptOrUnitNumber;
    private String city;
    private String province;
    private String postalCode;
    private String type;
    private long phoneNumber;
    private String phoneType;
    private long ohipNumber;
    private String ohipVersion;
    private String firstName;
    private String lastName;
    private String middleInitials;
    private char gender;
    private LocalDate dateOfBirth;

    public Patient() {
        super();
    }

    public Patient(String username, int role, String password, 
            long addressId, String streetLine1, String streetLine2, String aptOrUnitNumber, 
            String city, String province, String postalCode, String type, long phoneNumber, 
            String phoneType, long ohipNumber, String ohipVersion, String firstName, String lastName, 
            String middleInitials, char gender, LocalDate dateOfBirth) {
        super(username, role, password);
        this.addressId = addressId;
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.aptOrUnitNumber = aptOrUnitNumber;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.type = type;
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
        this.ohipNumber = ohipNumber;
        this.ohipVersion = ohipVersion;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitials = middleInitials;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
    
    // Constructor for account registration
    public Patient(String username, int role, String password, String streetLine1, 
            String streetLine2, String aptOrUnitNumber, String city, String province, 
            String postalCode, String type, long phoneNumber, String phoneType, 
            long ohipNumber, String ohipVersion, String firstName, String lastName, 
            String middleInitials, char gender, LocalDate dateOfBirth) {
        super(username, role, password);
        this.addressId = addressId;
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.aptOrUnitNumber = aptOrUnitNumber;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.type = type;
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
        this.ohipNumber = ohipNumber;
        this.ohipVersion = ohipVersion;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitials = middleInitials;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
/*
    public Patient(long addressId, String streetLine1, String streetLine2, String aptOrUnitNumber, String city, String province, String postalCode, String type, long phoneNumber, String phoneType, long ohipNumber, String ohipVersion, String firstName, String lastName, String middleInitials, char gender, LocalDate dateOfBirth, String username, int role, String password, Date dateOfLastLogin) {
        super(username, role, password, dateOfLastLogin);
        this.addressId = addressId;
        this.streetLine1 = streetLine1;
        this.streetLine2 = streetLine2;
        this.aptOrUnitNumber = aptOrUnitNumber;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.type = type;
        this.phoneNumber = phoneNumber;
        this.phoneType = phoneType;
        this.ohipNumber = ohipNumber;
        this.ohipVersion = ohipVersion;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitials = middleInitials;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
  */  
    

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getStreetLine1() {
        return streetLine1;
    }

    public void setStreetLine1(String streetLine1) {
        this.streetLine1 = streetLine1;
    }

    public String getStreetLine2() {
        return streetLine2;
    }

    public void setStreetLine2(String streetLine2) {
        this.streetLine2 = streetLine2;
    }

    public String getAptOrUnitNumber() {
        return aptOrUnitNumber;
    }

    public void setAptOrUnitNumber(String aptOrUnitNumber) {
        this.aptOrUnitNumber = aptOrUnitNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public long getOhipNumber() {
        return ohipNumber;
    }

    public void setOhipNumber(long ohipNumber) {
        this.ohipNumber = ohipNumber;
    }

    public String getOhipVersion() {
        return ohipVersion;
    }

    public void setOhipVersion(String ohipVersion) {
        this.ohipVersion = ohipVersion;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitials() {
        return middleInitials;
    }

    public void setMiddleInitials(String middleInitials) {
        this.middleInitials = middleInitials;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) throws Exception {
        LocalDate today = LocalDate.now();
        if (dateOfBirth.isBefore(today)) {
            this.dateOfBirth = dateOfBirth;
        } else {
            throw new Exception("Invalid date");
        }
    }

}
