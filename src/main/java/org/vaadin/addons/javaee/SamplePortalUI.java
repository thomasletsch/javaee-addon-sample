package org.vaadin.addons.javaee;

import java.util.Locale;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import org.vaadin.addons.javaee.events.NavigationEvent;
import org.vaadin.addons.javaee.i18n.SelectedLocale;
import org.vaadin.addons.javaee.navigation.SideMenu;
import org.vaadin.addons.javaee.page.PortalViewImpl;
import org.vaadin.addons.javaee.ui.CustomerEditPage;
import org.vaadin.addons.javaee.ui.CustomerNewPage;
import org.vaadin.addons.javaee.ui.CustomerSearchPage;
import org.vaadin.virkki.cdiutils.application.UIContext.UIScoped;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Constants;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme(Props.THEME_NAME)
@UIScoped
public class SamplePortalUI extends UI {

    @WebServlet(urlPatterns = "/*", initParams = { @WebInitParam(name = VaadinSession.UI_PARAMETER, value = Props.UI_NAME),
            @WebInitParam(name = Constants.SERVLET_PARAMETER_UI_PROVIDER, value = Props.UI_PROVIDER_NAME) })
    public static class ApplicationServlet extends VaadinServlet {
    }

    @Inject
    private PortalViewImpl mainView;

    @Inject
    private SelectedLocale selectedLocale;

    @Inject
    protected Instance<SideMenu> menu;

    @Inject
    private Instance<CustomerSearchPage> customerSearchPage;

    @Inject
    private Instance<CustomerNewPage> customerNewPage;

    @Inject
    private Instance<CustomerEditPage> customerOverviewPage;

    @Inject
    javax.enterprise.event.Event<NavigationEvent> navigation;

    @Override
    protected void init(final VaadinRequest request) {
        String customer = "Customer";
        menu.get().addMenu(customer, null);
        menu.get().addMenu(customer, CustomerSearchPage.PAGE, customerSearchPage);
        menu.get().addMenu(customer, CustomerNewPage.PAGE, customerNewPage);
        menu.get().addMenu(customer, CustomerEditPage.PAGE, customerOverviewPage);

        selectedLocale.setLocale(Locale.GERMANY);
        setLocale(selectedLocale.getLocale());
        setContent(mainView);
        mainView.openView();
        navigation.fire(new NavigationEvent(CustomerSearchPage.PAGE));
    }

}
