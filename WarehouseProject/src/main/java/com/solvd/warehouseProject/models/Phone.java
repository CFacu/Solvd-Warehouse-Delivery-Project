package com.solvd.warehouseProject.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "phone")
public class Phone extends AbstractEntity{
    private String number;

    public Phone() {
    }

    public Phone(String number) {
        this.number = number;
    }
    
    @XmlElement(name="number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
