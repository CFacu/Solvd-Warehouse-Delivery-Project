package com.solvd.warehouseProject.models;

import java.time.LocalDate;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.solvd.warehouseProject.parsers.LocalDateAdapter;



@XmlRootElement (name = "driver")
@XmlType(propOrder = { "firstName", "lastName", "age", "birthday", "phones" })
public class Driver extends AbstractEntity{
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthday;
    private List<Phone> phones;

    public Driver() {
    }

    public Driver(String firstName, String lastName, Integer age, LocalDate birthday, List<Phone> phones) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthday = birthday;
        this.phones = phones;
    }
    
    @XmlElement(name="first_name")
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@XmlElement(name="last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@XmlElement(name="age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @XmlElement(name="birthday")
    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    
    @XmlElementWrapper(name="phones")
    @XmlElement(name="phone")
    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
