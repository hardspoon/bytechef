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

package com.bytechef.component.dropbox.action;

import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

import com.bytechef.hermes.component.definition.ActionDefinition;
import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.ImportFormat;
import com.dropbox.core.v2.files.PaperCreateUploader;
import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

/**
 * @author Mario Cvjetojevic
 */
class DropboxCreateNewTextFileActionTest extends DropboxActionTestAbstract {

    @Test
    void testPerform() throws DbxException, IOException {
        PaperCreateUploader paperCreateUploader = Mockito.mock(PaperCreateUploader.class);

        ArgumentCaptor<ImportFormat> importFormatArgumentCaptor = ArgumentCaptor.forClass(ImportFormat.class);
        ArgumentCaptor<InputStream> inputStreamArgumentCaptor = ArgumentCaptor.forClass(InputStream.class);

        Mockito.when(filesRequests.paperCreate(DESTINATION_STUB, ImportFormat.PLAIN_TEXT))
            .thenReturn(paperCreateUploader);

        DropboxCreateNewTextFileAction.perform(
            parameterMap, parameterMap, Mockito.mock(ActionDefinition.ActionContext.class));

        then(filesRequests).should(times(1))
            .paperCreate(stringArgumentCaptorA.capture(), importFormatArgumentCaptor.capture());
        then(paperCreateUploader).should(times(1))
            .uploadAndFinish(inputStreamArgumentCaptor.capture());

        Assertions.assertEquals(DESTINATION_STUB, stringArgumentCaptorA.getValue());
        Assertions.assertEquals(ImportFormat.PLAIN_TEXT, importFormatArgumentCaptor.getValue());
        Assertions.assertEquals(
            -1, inputStreamArgumentCaptor.getValue()
                .read(),
            "Input stream must be empty!");
    }
}
