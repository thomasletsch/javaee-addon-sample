package org.vaadin.addons.javaee;

import java.util.Locale;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.vaadin.addons.javaee.navigation.NavigationEvent;
import org.vaadin.addons.javaee.navigation.SideMenu;
import org.vaadin.addons.javaee.ui.CustomerEditPage;
import org.vaadin.addons.javaee.ui.CustomerNewPage;
import org.vaadin.addons.javaee.ui.CustomerSearchPage;

import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;

@SuppressWarnings("serial")
@Theme(Props.THEME_NAME)
@CDIUI
public class SamplePortalUI extends PortalUI {

    @Inject
    protected SideMenu menu;

    @Inject
    private Instance<CustomerSearchPage> customerSearchPage;

    @Inject
    private Instance<CustomerNewPage> customerNewPage;

    @Inject
    private Instance<CustomerEditPage> customerOverviewPage;

    @Override
    protected void initPortal() {
        String customer = "Customer";
        menu.addMenu(customer, null);
        menu.addMenu(customer, CustomerSearchPage.PAGE, customerSearchPage);
        menu.addMenu(customer, CustomerNewPage.PAGE, customerNewPage);
        menu.addMenu(customer, CustomerEditPage.PAGE, customerOverviewPage);

        selectedLocale.setLocale(Locale.GERMANY);
        navigation.fire(new NavigationEvent(CustomerSearchPage.PAGE));
    }

}
