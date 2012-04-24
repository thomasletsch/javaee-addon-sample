package org.vaadin.addons.javaee;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.vaadin.addons.javaee.page.Portal;
import org.vaadin.addons.javaee.ui.CustomerEditPage;
import org.vaadin.addons.javaee.ui.CustomerNewPage;
import org.vaadin.addons.javaee.ui.CustomerSearchPage;


@SessionScoped
public class SamplePortal extends Portal {

    @Inject
    private Instance<CustomerSearchPage> customerSearchPage;

    @Inject
    private Instance<CustomerNewPage> customerNewPage;

    @Inject
    private Instance<CustomerEditPage> customerOverviewPage;

    @Override
    protected void initMenu() {
        String customer = "Customer";
        menu.addMenu(customer, null);
        menu.addMenu(customer, CustomerSearchPage.PAGE, customerSearchPage);
        menu.addMenu(customer, CustomerNewPage.PAGE, customerNewPage);
        menu.addMenu(customer, CustomerEditPage.PAGE, customerOverviewPage);
    }

}
