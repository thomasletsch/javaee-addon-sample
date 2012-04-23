package org.vaadin.addons.javaee.ui;

import org.vaadin.addons.javaee.domain.Customer;
import org.vaadin.addons.javaee.jpa.EntityContainer;


public class CustomerContainer extends EntityContainer<Customer> {

    public CustomerContainer() {
        super(Customer.class, false);
    }

}
