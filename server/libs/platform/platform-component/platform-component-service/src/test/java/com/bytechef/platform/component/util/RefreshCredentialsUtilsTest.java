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

package com.bytechef.platform.component.util;

import com.bytechef.component.exception.ProviderException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Igor Beslic
 */
public class RefreshCredentialsUtilsTest {

    private static final String multilineMessage = """
        401 Unauthorized
        POST https://ss.gopis.com/v4/spreadsheets/132YEL8BnzkalU40J2/values/Sheet1:append?valueInputOption=RAW
        """;

    @Test
    public void testGetByExceptionMessage() {
        Assertions.assertTrue(RefreshCredentialsUtils.matches(List.of(401), new ProviderException(401)));

        String pattern = "^.*(4\\d\\d)(\\s(Unauthorized)?.*)?$";

        Assertions.assertTrue(RefreshCredentialsUtils.matches(List.of(pattern), new Exception("401 Unauthorized")));
        Assertions.assertTrue(RefreshCredentialsUtils.matches(List.of(pattern), new Exception(multilineMessage)));
        Assertions.assertTrue(
            RefreshCredentialsUtils.matches(List.of(pattern), new ProviderException(new Exception(multilineMessage))));
        Assertions.assertTrue(
            RefreshCredentialsUtils.matches(
                List.of(pattern), new ProviderException("Refresh token is expired", new Exception(multilineMessage))));
    }
}
