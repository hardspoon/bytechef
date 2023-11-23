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

import static com.bytechef.component.dropbox.constant.DropboxConstants.DESTINATION_FILENAME;
import static com.bytechef.component.dropbox.constant.DropboxConstants.MOVE;
import static com.bytechef.component.dropbox.constant.DropboxConstants.SOURCE_FILENAME;
import static com.bytechef.component.dropbox.util.DropboxUtils.getDropboxRequestObject;
import static com.bytechef.hermes.component.definition.ComponentDSL.action;
import static com.bytechef.hermes.component.definition.constant.AuthorizationConstants.ACCESS_TOKEN;
import static com.bytechef.hermes.definition.DefinitionDSL.string;

import com.bytechef.hermes.component.definition.ActionDefinition.ActionContext;
import com.bytechef.hermes.component.definition.ComponentDSL.ModifiableActionDefinition;
import com.bytechef.hermes.component.definition.ParameterMap;
import com.bytechef.hermes.component.exception.ComponentExecutionException;
import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.RelocationResult;

/**
 * @author Mario Cvjetojevic
 */
public final class DropboxMoveAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action(MOVE)
        .title("Move")
        .description("""
            Move a file or folder to a different location in the user's Dropbox.
            If the source path is a folder all its contents will be moved.
            Note that we do not currently support case-only renaming.""")
        .properties(
            string(SOURCE_FILENAME)
                .label("Source path")
                .description("Path in the user's Dropbox to be moved. Must match pattern " +
                    "\"(/(.|[\\\\r\\\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)\" and not be null.")
                .required(true),
            string(DESTINATION_FILENAME)
                .label("Destination path")
                .description("Path in the user's Dropbox that is the destination. Must match pattern " +
                    "\"(/(.|[\\\\r\\\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)\" and not be null.")
                .required(true))
        .perform(DropboxMoveAction::perform);

    protected static RelocationResult perform(
        ParameterMap inputParameters, ParameterMap connectionParameters, ActionContext actionContext)
        throws ComponentExecutionException {
        try {
            return getDropboxRequestObject(connectionParameters.getRequiredString(ACCESS_TOKEN))
                .moveV2(
                    inputParameters.getRequiredString(SOURCE_FILENAME),
                    inputParameters.getRequiredString(DESTINATION_FILENAME));
        } catch (DbxException dbxException) {
            throw new ComponentExecutionException("Unable to move " + inputParameters, dbxException);
        }
    }

    private DropboxMoveAction() {
    }
}
