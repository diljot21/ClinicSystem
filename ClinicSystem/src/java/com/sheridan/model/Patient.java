
package com.sheridan.model;

/**
 *
 * @author DILJOT
 */
public class Patient{
    private String username;
    private String password;
    private int role;
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
    private String dateOfBirth;

    public Patient() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
}
