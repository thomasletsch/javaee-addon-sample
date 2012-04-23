package org.vaadin.addons.javaee.ui;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.vaadin.addons.javaee.domain.Customer;
import org.vaadin.addons.javaee.events.NavigationEvent;
import org.vaadin.addons.javaee.form.BasicSearchForm;
import org.vaadin.addons.javaee.page.BasicSearchAndListPage;
import org.vaadin.addons.javaee.table.BasicEntityTable;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;

public class CustomerSearchPage extends BasicSearchAndListPage<Customer> {

    public static final String PAGE = "CustomerSearch";

    public static final String ENTITY = "Customer";

    @Inject
    CustomerListTable customerListTable;

    @Inject
    CustomerSearchForm searchForm;

    @Inject
    CustomerHolder customerHolder;

    @Inject
    javax.enterprise.event.Event<NavigationEvent> navigation;

    @Inject
    javax.enterprise.event.Event<CustomerChangedEvent> customerChanged;

    public CustomerSearchPage() {
        super(PAGE, ENTITY);
    }

    @PostConstruct
    protected void bindCustomerChanged() {
        customerListTable.addListener(new ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                customerChanged.fire(new CustomerChangedEvent(customerListTable.getSelectedEntity()));
                navigation.fire(new NavigationEvent(CustomerEditPage.PAGE));
            }
        });
    }

    @Override
    protected BasicSearchForm<Customer> getSearchForm() {
        return searchForm;
    }

    @Override
    protected BasicEntityTable<Customer> getResultTable() {
        return customerListTable;
    }
}
