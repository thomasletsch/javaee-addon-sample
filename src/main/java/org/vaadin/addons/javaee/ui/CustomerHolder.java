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

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.vaadin.addons.javaee.domain.Customer;

import com.vaadin.data.Container.Filter;
import com.vaadin.data.Item;
import com.vaadin.data.util.filter.Compare.Equal;

@SessionScoped
public class CustomerHolder implements Serializable {

    private Customer customer;

    @Inject
    private CustomerContainer customerContainer;

    public CustomerHolder() {
    }

    public void setCustomer(@Observes Customer customer) {
        this.customer = customer;
    }

    public void handleCustomerChanged(@Observes CustomerChangedEvent event) {
        customer = event.getCustomer();
    }

    public Customer getCustomer() {
        return customer;
    }

    public Item getItem() {
        return customerContainer.getItem(customer.getId());
    }

    public Filter getFilter() {
        Filter filter = new Equal("customer", customer);
        return filter;
    }

}
