package org.vaadin.addons.javaee.ui;

import javax.inject.Inject;

import org.vaadin.addons.javaee.domain.Customer;
import org.vaadin.addons.javaee.form.BasicEntityForm;
import org.vaadin.addons.javaee.page.BasicEditPage;


public class CustomerEditPage extends BasicEditPage<Customer> {

    public static final String PAGE = "CustomerEdit";

    public static final String ENTITY = "Customer";

    @Inject
    CustomerForm form;

    @Inject
    CustomerHolder customerHolder;

    public CustomerEditPage() {
        super(PAGE, ENTITY);
    }

    @Override
    protected BasicEntityForm<Customer> getForm() {
        return form;
    }

    @Override
    public void onShow(String comingFrom) {
        super.onShow(comingFrom);
        form.edit(customerHolder.getItem());
    }
}
