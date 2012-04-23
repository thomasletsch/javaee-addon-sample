package org.vaadin.addons.javaee.ui;

import javax.inject.Inject;

import org.vaadin.addons.javaee.domain.Customer;
import org.vaadin.addons.javaee.fields.StringToCalenderConverter;
import org.vaadin.addons.javaee.jpa.EntityContainer;
import org.vaadin.addons.javaee.table.BasicEntityTable;


public class CustomerListTable extends BasicEntityTable<Customer> {

    @Inject
    private CustomerContainer customerContainer;

    public CustomerListTable() {
        super(Customer.class);
    }

    @Override
    protected void initColumns() {
        addColumn(CustomerFields.SALUTATION);
        addColumn(CustomerFields.FIRST_NAME);
        addColumn(CustomerFields.LAST_NAME);
        addColumn(CustomerFields.ADDRESS + "." + AddressFields.STREET);
        addColumn(CustomerFields.ADDRESS + "." + AddressFields.ZIP);
        addColumn(CustomerFields.ADDRESS + "." + AddressFields.CITY);
        addColumn(CustomerFields.DATE_OF_BIRTH);
        setConverter(CustomerFields.DATE_OF_BIRTH, new StringToCalenderConverter(StringToCalenderConverter.DATE_ONLY_PATTERN));
    }

    @Override
    public EntityContainer<Customer> getContainer() {
        return customerContainer;
    }

}
