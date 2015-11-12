package domain;


import java.util.Date;
import java.util.UUID;
import java.time.LocalDate;
import java.time.ZoneId;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import util.LocalDateAdapter;

public class PersonDomainModel {
	
	private  UUID personID;
    private  String firstName;
    private  String lastName;
    private  String street;
    private  Integer postalCode;
    private  String city;
    private  Date birthday;

    /**
     * Default constructor.
     */


    
    public String getFirstName() {
        return firstName;
    }

    public UUID getPersonID() {
		return personID;
	}

	public void setPersonID(UUID personID) {
		this.personID = personID;
	}

	public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public StringProperty firstNameProperty(){
    	return(new SimpleStringProperty(firstName));
    }
    
    public StringProperty lastNameProperty(){
    	return(new SimpleStringProperty(lastName));
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    public void setBirthday(LocalDate birthday){
    	this.birthday = Date.from(birthday.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}