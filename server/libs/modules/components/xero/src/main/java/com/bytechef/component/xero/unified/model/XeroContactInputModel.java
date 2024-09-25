/*
 * Copyright 2023-present ByteChef Inc.
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

package com.bytechef.component.xero.unified.model;

import com.bytechef.component.definition.unified.crm.model.ProviderContactInputModel;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ivica Cardic
 */
@SuppressFBWarnings("EI")
// CHECKSTYLE:OFF
public class XeroContactInputModel extends HashMap<String, Object> implements ProviderContactInputModel {

    protected XeroContactInputModel() {
    }

    public XeroContactInputModel(Map<String, Object> customFields) {
        this.putAll(customFields);
    }
}