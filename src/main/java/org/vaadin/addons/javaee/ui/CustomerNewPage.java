package org.vaadin.addons.javaee.ui;

import javax.inject.Inject;

import org.vaadin.addons.javaee.domain.Customer;

import com.optible.vaadin.utils.form.BasicEntityForm;
import com.optible.vaadin.utils.page.BasicEditPage;

public class CustomerNewPage extends BasicEditPage<Customer> {

    public static final String PAGE = "CustomerNew";

    public static final String ENTITY = "Customer";

    @Inject
    CustomerForm form;

    @Inject
    javax.enterprise.event.Event<CustomerChangedEvent> customerChanged;

    public CustomerNewPage() {
        super(PAGE, ENTITY);
    }

    @Override
    protected BasicEntityForm<Customer> getForm() {
        return form;
    }

    @Override
    public void onShow(String comingFrom) {
        super.onShow(comingFrom);
        form.editNew();
    }

    @Override
    public void saveClicked() {
        super.saveClicked();
        CustomerChangedEvent event = new CustomerChangedEvent(form.getEntity());
        customerChanged.fire(event);
    }
}
