/*
 *
 *  Copyright 2012-2014 Eurocommercial Properties NV
 *
 *
 *  Licensed under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.estatio.fixture.asset;

import org.estatio.dom.asset.PropertyType;
import org.estatio.dom.geography.Country;
import org.estatio.dom.party.Party;
import org.estatio.fixture.geography.refdata.CountriesAndStatesRefData;
import org.estatio.fixture.party.OrganisationForHelloWorld;
import org.estatio.fixture.party.PersonForJohnDoe;

import static org.estatio.integtests.VT.ld;

public class PropertyForViv extends PropertyAbstract {

    public static final String PROPERTY_REFERENCE = "VIV";

    public static String unitReference(String suffix) {
        return PROPERTY_REFERENCE + "-" + suffix;
    }

    @Override
    protected void execute(ExecutionContext executionContext) {

        // prereqs
        if(isExecutePrereqs()) {
            executionContext.executeChild(this, new OrganisationForHelloWorld());
            executionContext.executeChild(this, new PersonForJohnDoe());
        }

        // exec
        Party owner = parties.findPartyByReference(OrganisationForHelloWorld.PARTY_REFERENCE);
        Party manager = parties.findPartyByReference(PersonForJohnDoe.PARTY_REFERENCE);

        Country france = countries.findCountry(CountriesAndStatesRefData.FRA);
        createPropertyAndUnits(
                PROPERTY_REFERENCE, "Vive les shops", "Paris", france, PropertyType.SHOPPING_CENTER, 5,
                ld(2004, 5, 6), ld(2008, 6, 1), owner, manager, "48.8740002697085;2.326230019708498",
                executionContext);
    }

}
