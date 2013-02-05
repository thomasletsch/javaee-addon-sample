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
package org.vaadin.addons.javaee.ui;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.vaadin.addons.javaee.domain.Customer;
import org.vaadin.addons.javaee.events.NavigationEvent;
import org.vaadin.addons.javaee.form.BasicSearchForm;
import org.vaadin.addons.javaee.page.BasicSearchAndListPage;
import org.vaadin.addons.javaee.page.ContentView;
import org.vaadin.addons.javaee.table.BasicEntityTable;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;

public class CustomerSearchPage extends BasicSearchAndListPage<Customer> implements ContentView {

    private static final long serialVersionUID = 1L;

    public static final String PAGE = "CustomerSearch";

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
        super(PAGE);
    }

    @PostConstruct
    protected void bindCustomerChanged() {
        customerListTable.addValueChangeListener(new ValueChangeListener() {

            private static final long serialVersionUID = 1L;

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
