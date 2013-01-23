package org.vaadin.addons.javaee.ui;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.vaadin.addons.javaee.TranslationKeys;
import org.vaadin.addons.javaee.domain.Customer;
import org.vaadin.addons.javaee.i18n.TranslationService;
import org.vaadin.addons.javaee.jpa.EntityItem;
import org.vaadin.addons.javaee.page.Header;

import com.vaadin.data.Container.Filter;
import com.vaadin.data.util.filter.Compare.Equal;

@SessionScoped
public class CustomerHolder implements Serializable {

    private static final long serialVersionUID = 1L;

    private Customer customer;

    @Inject
    private CustomerContainer customerContainer;

    @Inject
    private TranslationService translationService;

    @Inject
    private Header header;

    public CustomerHolder() {
    }

    public void setCustomer(@Observes Customer customer) {
        this.customer = customer;
        updateHeader(customer);
    }

    public void handleCustomerChanged(@Observes CustomerChangedEvent event) {
        customer = event.getCustomer();
        updateHeader(customer);
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

    protected void updateHeader(Customer customer) {
        header.setCaption(translationService.getText(TranslationKeys.TITLE_PORTAL) + ":" + customer.getFullName());
    }

}
