/*
 *  Copyright 2014 Dan Haywood
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
package org.estatio.fixture.security.tenancy;

public class ApplicationTenancyRootOnly extends AbstractApplicationTenancyFixtureScript {

    public static final String TENANCY_NAME = "Global";
    public static final String COUNTRY_REFERENCE = null;
    public static final String PATH = "/" + AbstractApplicationTenancyFixtureScript.ONLY_IDENTIFIER;

    @Override
    protected void execute(final ExecutionContext executionContext) {
        create(TENANCY_NAME, PATH, executionContext);
    }

}
