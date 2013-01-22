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

import javax.inject.Inject;

import org.vaadin.addons.javaee.domain.Customer;
import org.vaadin.addons.javaee.fields.converter.StringToCalenderConverter;
import org.vaadin.addons.javaee.jpa.EntityContainer;
import org.vaadin.addons.javaee.table.BasicEntityTable;

public class CustomerListTable extends BasicEntityTable<Customer> {

    private static final long serialVersionUID = 1L;

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
