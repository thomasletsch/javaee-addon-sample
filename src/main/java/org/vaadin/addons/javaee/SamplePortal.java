/*******************************************************************************
 * Copyright 2012 Thomas Letsch
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *******************************************************************************/
package org.vaadin.addons.javaee;

import static org.vaadin.addons.javaee.TranslationKeys.*;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.vaadin.addons.javaee.page.Portal;
import org.vaadin.addons.javaee.ui.CustomerChangedEvent;
import org.vaadin.addons.javaee.ui.CustomerEditPage;
import org.vaadin.addons.javaee.ui.CustomerNewPage;
import org.vaadin.addons.javaee.ui.CustomerSearchPage;

import com.vaadin.annotations.Theme;

@SessionScoped
@Theme("sample")
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

    public void adjustHeader(@Observes CustomerChangedEvent event) {
        header.setTitle(translationService.get(TITLE_PORTAL) + " - " + event.getCustomer().getFullName());
    }

}
