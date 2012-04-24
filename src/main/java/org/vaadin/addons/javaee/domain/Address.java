package org.vaadin.addons.javaee.domain;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import com.googlecode.javaeeutils.jpa.AuditableEntity;

@Entity
@Cacheable
public class Address extends AuditableEntity {

    @Size(max = 100)
    private String street;

    @Size(max = 100)
    private String city;

    @Size(max = 10)
    private String zip;

    @Size(min = 2, max = 2)
    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
