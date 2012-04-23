package org.vaadin.addons.javaee.domain;

import java.util.Calendar;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.javaeeutils.jpa.AuditableEntity;

@Entity
@Cacheable
public class Customer extends AuditableEntity {

    @Enumerated(EnumType.STRING)
    private SalutationType salutation;

    private String title;

    @Size(max = 100)
    private String firstName;

    @Size(max = 100)
    private String lastName;

    @Temporal(TemporalType.DATE)
    private Calendar dateOfBirth;

    @Size(max = 20)
    private String phone;

    @Size(max = 20)
    private String mobile;

    @Size(max = 50)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @Size(max = 1024)
    private String additionalInformation;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
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

    public Address getAddress() {
        if (address == null) {
            address = new Address();
        }
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public SalutationType getSalutation() {
        return salutation;
    }

    public void setSalutation(SalutationType salutation) {
        this.salutation = salutation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

}
