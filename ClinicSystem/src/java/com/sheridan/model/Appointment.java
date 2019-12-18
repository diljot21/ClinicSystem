
package com.sheridan.model;

/**
 *
 * @author DILJOT
 */
public class Appointment {
    
    private int apptNumber;
    private long patient;
    private String reasonForVisit;
    private String dateTime;
    private String isCheckedIn;

    public Appointment() {
    }
    
    public Appointment(int apptNumber, long patient, String reasonForVisit, String dateTime, String isCheckedIn) {
        this.apptNumber = apptNumber;
        this.patient = patient;
        this.reasonForVisit = reasonForVisit;
        this.dateTime = dateTime;
        this.isCheckedIn = isCheckedIn;
    }

    public int getApptNumber() {
        return apptNumber;
    }

    public void setApptNumber(int apptNumber) {
        this.apptNumber = apptNumber;
    }

    public long getPatient() {
        return patient;
    }

    public void setPatient(long patient) {
        this.patient = patient;
    }

    public String getReasonForVisit() {
        return reasonForVisit;
    }

    public void setReasonForVisit(String reasonForVisit) {
        this.reasonForVisit = reasonForVisit;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getIsCheckedIn() {
        return isCheckedIn;
    }

    public void setIsCheckedIn(String isCheckedIn) {
        this.isCheckedIn = isCheckedIn;
    }
    
    
    
}
