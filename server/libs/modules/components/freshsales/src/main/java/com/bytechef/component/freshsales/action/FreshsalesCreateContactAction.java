/*
 * Copyright 2025 ByteChef
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bytechef.component.freshsales.action;

import static com.bytechef.component.definition.ComponentDsl.action;
import static com.bytechef.component.definition.ComponentDsl.number;
import static com.bytechef.component.definition.ComponentDsl.object;
import static com.bytechef.component.definition.ComponentDsl.outputSchema;
import static com.bytechef.component.definition.ComponentDsl.string;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.ADDRESS;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.CITY;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.COUNTRY;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.EMAIL;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.FACEBOOK;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.FIRST_NAME;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.ID;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.JOB_TITLE;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.LAST_NAME;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.LINKEDIN;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.MEDIUM;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.MOBILE_NUMBER;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.STATE;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.TWITTER;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.WORK_NUMBER;
import static com.bytechef.component.freshsales.constant.FreshsalesConstants.ZIPCODE;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.ComponentDsl.ModifiableActionDefinition;
import com.bytechef.component.definition.Context.Http;
import com.bytechef.component.definition.Parameters;
import com.bytechef.component.definition.Property.ControlType;
import com.bytechef.component.definition.TypeReference;

/**
 * @author Monika Domiter
 */
public class FreshsalesCreateContactAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action("createContact")
        .title("Create Contact")
        .description("Add new contact in Freshsales CRM.")
        .properties(
            string(FIRST_NAME)
                .label("First Name")
                .description("First name of the contact.")
                .required(false),
            string(LAST_NAME)
                .label("Last Name")
                .description("Last name of the contact.")
                .required(false),
            string(JOB_TITLE)
                .label("Job Title")
                .description("Designation of the contact in the account they belong to.")
                .required(false),
            string(EMAIL)
                .label("Email")
                .description("Primary email address of the contact.")
                .controlType(ControlType.EMAIL)
                .required(true),
            string(WORK_NUMBER)
                .label("Work Number")
                .description("Work phone number of the contact.")
                .controlType(ControlType.PHONE)
                .required(false),
            string(MOBILE_NUMBER)
                .label("Mobile Number")
                .description("Mobile phone number of the contact.")
                .required(false),
            string(ADDRESS)
                .label("Address")
                .description("Address of the contact.")
                .required(false),
            string(CITY)
                .label("City")
                .description("City that the contact belongs to.")
                .required(false),
            string(STATE)
                .label("State")
                .description("State that the contact belongs to.")
                .required(false),
            string(ZIPCODE)
                .label("Zip Code")
                .description("Zipcode of the region that the contact belongs to.")
                .required(false),
            string(COUNTRY)
                .label("Country")
                .description("Country that the contact belongs to.")
                .required(false),
            string(MEDIUM)
                .label("Medium")
                .description("The medium that led your contact to your website/web ap.p")
                .required(false),
            string(FACEBOOK)
                .label("Facebook")
                .description("Facebook username of the contact.")
                .required(false),
            string(TWITTER)
                .label("Twitter")
                .description("Twitter username of the contact.")
                .required(false),
            string(LINKEDIN)
                .label("LinkedIn")
                .description("LinkedIn account of the contact.")
                .required(false))
        .output(
            outputSchema(
                object()
                    .properties(
                        object("contact")
                            .properties(
                                number(ID)
                                    .description("ID of the contact."),
                                string(FIRST_NAME)
                                    .description("First name of the contact."),
                                string(LAST_NAME)
                                    .description("Last name of the contact."),
                                string(JOB_TITLE)
                                    .description("Designation of the contact in the account he belongs to."),
                                string(CITY)
                                    .description("City that the contact belongs to."),
                                string(STATE)
                                    .description("State that the contact belongs to."),
                                string(ZIPCODE)
                                    .description("Zipcode of the region that the contact belongs to."),
                                string(COUNTRY)
                                    .description("Country that the contact belongs to."),
                                string(EMAIL)
                                    .description("Primary email address of the contact."),
                                string(WORK_NUMBER)
                                    .description("Work phone number of the contact."),
                                string(MOBILE_NUMBER)
                                    .description("Mobile phone number of the contact."),
                                string(ADDRESS)
                                    .description("Address of the contact."),
                                string(MEDIUM)
                                    .description("The medium that led your contact to your website/ web app."),
                                string(FACEBOOK)
                                    .description("Facebook username of the contact."),
                                string(TWITTER)
                                    .description("Twitter username of the contact."),
                                string(LINKEDIN)
                                    .description("LinkedIn account of the contact.")))))
        .perform(FreshsalesCreateContactAction::perform);

    private FreshsalesCreateContactAction() {
    }

    public static Object perform(
        Parameters inputParameters, Parameters connectionParameters, ActionContext actionContext) {

        return actionContext.http(http -> http.post("/contacts"))
            .body(
                Http.Body.of(
                    FIRST_NAME, inputParameters.getString(FIRST_NAME),
                    LAST_NAME, inputParameters.getString(LAST_NAME),
                    JOB_TITLE, inputParameters.getString(JOB_TITLE),
                    EMAIL, inputParameters.getRequiredString(EMAIL),
                    WORK_NUMBER, inputParameters.getString(WORK_NUMBER),
                    MOBILE_NUMBER, inputParameters.getString(MOBILE_NUMBER),
                    ADDRESS, inputParameters.getString(ADDRESS),
                    CITY, inputParameters.getString(CITY),
                    STATE, inputParameters.getString(STATE),
                    ZIPCODE, inputParameters.getString(ZIPCODE),
                    COUNTRY, inputParameters.getString(COUNTRY),
                    MEDIUM, inputParameters.getString(MEDIUM),
                    FACEBOOK, inputParameters.getString(FACEBOOK),
                    TWITTER, inputParameters.getString(TWITTER),
                    LINKEDIN, inputParameters.getString(LINKEDIN)))
            .configuration(Http.responseType(Http.ResponseType.JSON))
            .execute()
            .getBody(new TypeReference<>() {});
    }

}
