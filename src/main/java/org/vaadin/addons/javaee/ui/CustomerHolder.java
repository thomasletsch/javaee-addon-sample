package org.vaadin.addons.javaee.ui;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.vaadin.addons.javaee.domain.Customer;
import org.vaadin.addons.javaee.jpa.EntityItem;

import com.vaadin.data.Container.Filter;
import com.vaadin.data.util.filter.Compare.Equal;

@SessionScoped
public class CustomerHolder implements Serializable {

    private Customer customer;

    @Inject
    private CustomerContainer customerContainer;

    public CustomerHolder() {
    }

    public void setCustomer(@Observes Customer customer) {
        this.customer = customer;
    }

    public void handleCustomerChanged(@Observes CustomerChangedEvent event) {
        customer = event.getCustomer();
    }

    public Customer getCustomer() {
        return customer;
    }

    public EntityItem<Customer> getItem() {
        return customerContainer.getItem(customer.getId());
    }

    public Filter getFilter() {
        Filter filter = new Equal("customer", customer);
        return filter;
    }

}
