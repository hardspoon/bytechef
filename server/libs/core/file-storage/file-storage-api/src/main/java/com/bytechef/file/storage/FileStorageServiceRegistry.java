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

package com.bytechef.file.storage;

import com.bytechef.commons.util.MapUtils;
import com.bytechef.file.storage.service.FileStorageService;
import java.util.List;
import java.util.Map;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author Ivica Cardic
 */
@Component
public class FileStorageServiceRegistry {

    private final Map<String, FileStorageService> fileStorageServiceMap;

    public FileStorageServiceRegistry(List<FileStorageService> fileStorageServices) {
        this.fileStorageServiceMap = MapUtils.toMap(
            fileStorageServices, FileStorageService::getType, fileStorageService -> fileStorageService);
    }

    @NonNull
    public FileStorageService getFileStorageService(String type) {
        return fileStorageServiceMap.get(type);
    }
}
