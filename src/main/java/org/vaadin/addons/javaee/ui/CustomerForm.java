package org.vaadin.addons.javaee.ui;

import java.util.Arrays;

import javax.inject.Inject;

import org.vaadin.addons.javaee.domain.Customer;
import org.vaadin.addons.javaee.form.BasicEntityForm;
import org.vaadin.addons.javaee.jpa.EntityContainer;


public class CustomerForm extends BasicEntityForm<Customer> {

    @Inject
    private CustomerContainer customerContainer;

    public CustomerForm() {
        super(Customer.class);
    }

    @Override
    protected void initFields() {
        initFields(Arrays.asList(CustomerFields.SALUTATION, CustomerFields.FIRST_NAME, CustomerFields.LAST_NAME, CustomerFields.ADDRESS
                + "." + AddressFields.STREET, CustomerFields.ADDRESS + "." + AddressFields.ZIP, CustomerFields.ADDRESS + "."
                + AddressFields.CITY, CustomerFields.MOBILE, CustomerFields.PHONE, CustomerFields.DATE_OF_BIRTH));
    }

    @Override
    protected EntityContainer<Customer> getContainer() {
        return customerContainer;
    }

}
