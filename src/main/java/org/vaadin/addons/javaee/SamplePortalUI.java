package org.vaadin.addons.javaee;

import java.util.Locale;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import org.vaadin.addons.javaee.events.NavigationEvent;
import org.vaadin.addons.javaee.ui.CustomerEditPage;
import org.vaadin.addons.javaee.ui.CustomerNewPage;
import org.vaadin.addons.javaee.ui.CustomerSearchPage;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Constants;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;

@SuppressWarnings("serial")
@Theme(Props.THEME_NAME)
public class SamplePortalUI extends PortalUI {

    @WebServlet(urlPatterns = "/*", initParams = { @WebInitParam(name = VaadinSession.UI_PARAMETER, value = Props.UI_NAME),
            @WebInitParam(name = Constants.SERVLET_PARAMETER_UI_PROVIDER, value = Props.UI_PROVIDER_NAME) })
    public static class ApplicationServlet extends VaadinServlet {
    }

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
