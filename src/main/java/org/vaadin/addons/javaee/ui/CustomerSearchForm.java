package org.vaadin.addons.javaee.ui;

import java.util.Arrays;

import javax.inject.Inject;

import org.vaadin.addons.javaee.domain.Customer;

import com.optible.vaadin.utils.form.BasicSearchForm;
import com.optible.vaadin.utils.jpa.EntityContainer;

public class CustomerSearchForm extends BasicSearchForm<Customer> {

    @Inject
    private CustomerContainer customerContainer;

    public CustomerSearchForm() {
        super(Customer.class);
    }

    @Override
    protected void initFields() {
        initFields(Arrays.asList(CustomerFields.FIRST_NAME, CustomerFields.LAST_NAME));
    }

    @Override
    protected EntityContainer<Customer> getContainer() {
        return customerContainer;
    }
}
