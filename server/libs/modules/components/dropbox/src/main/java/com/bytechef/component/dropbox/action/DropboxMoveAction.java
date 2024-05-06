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

import static com.bytechef.component.definition.Authorization.ACCESS_TOKEN;
import static com.bytechef.component.definition.ComponentDSL.action;
import static com.bytechef.component.definition.ComponentDSL.object;
import static com.bytechef.component.definition.ComponentDSL.string;
import static com.bytechef.component.dropbox.constant.DropboxConstants.DESTINATION;
import static com.bytechef.component.dropbox.constant.DropboxConstants.FILENAME;
import static com.bytechef.component.dropbox.constant.DropboxConstants.MOVE;
import static com.bytechef.component.dropbox.constant.DropboxConstants.SOURCE;
import static com.bytechef.component.dropbox.util.DropboxUtils.getDbxUserFilesRequests;

import com.bytechef.component.definition.ActionContext;
import com.bytechef.component.definition.ComponentDSL.ModifiableActionDefinition;
import com.bytechef.component.definition.Parameters;
import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.DbxUserFilesRequests;
import com.dropbox.core.v2.files.RelocationResult;

/**
 * @author Mario Cvjetojevic
 */
public final class DropboxMoveAction {

    public static final ModifiableActionDefinition ACTION_DEFINITION = action(MOVE)
        .title("Move")
        .description(
            "Move a file or folder to a different location in the user's Dropbox. If the source path is a folder all " +
                "its contents will be moved. Note that we do not currently support case-only renaming.")
        .properties(
            string(FILENAME)
                .label("Filename")
                .description("Name of the file with the extension. Don't fill in if you want a folder.")
                .required(false),
            string(SOURCE)
                .label("Source path")
                .description("Path in the user's Dropbox to be moved.  Root is /.")
                .required(true),
            string(DESTINATION)
                .label("Destination path")
                .description("Path in the user's Dropbox that is the destination. Root is /.")
                .required(true))
        .outputSchema(
            object()
                .properties(
                    object("metadata")
                        .properties(
                            string("name")
                                .required(true),
                            string("pathLower")
                                .required(true),
                            string("pathDisplay")
                                .required(true),
                            string("parentSharedFolderId")
                                .required(true),
                            string("previewUrl")
                                .required(true))
                        .label("Metadata")))
        .perform(DropboxMoveAction::perform);

    private DropboxMoveAction() {
    }

    public static RelocationResult perform(
        Parameters inputParameters, Parameters connectionParameters, ActionContext actionContext)
        throws DbxException {

        DbxUserFilesRequests dbxUserFilesRequests = getDbxUserFilesRequests(
            connectionParameters.getRequiredString(ACCESS_TOKEN));

        String filename = inputParameters.getRequiredString(FILENAME);
        String source = inputParameters.getRequiredString(SOURCE);

        source = source.endsWith("/") ? source : source + "/";

        String destination = inputParameters.getRequiredString(DESTINATION);

        destination = destination.endsWith("/") ? destination : destination + "/";

        return dbxUserFilesRequests.moveV2(source + filename, destination + filename);
    }
}
