package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EmergencyService {
    long contactNumber;
     String  serviceName, serviceType;

    // Empty constructor required for Firebase
    public EmergencyService() {
    }

    public EmergencyService(long contactNumber,String serviceName, String serviceType) {

        this.contactNumber = contactNumber;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }


    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

}
