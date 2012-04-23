package org.vaadin.addons.javaee.ui;

import org.vaadin.addons.javaee.domain.Customer;

public class CustomerChangedEvent {

    private final Customer customer;

    public CustomerChangedEvent(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

}
