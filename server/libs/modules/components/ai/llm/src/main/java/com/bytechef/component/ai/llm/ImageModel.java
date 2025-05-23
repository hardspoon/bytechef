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

package com.bytechef.component.ai.llm;

import static com.bytechef.component.ai.llm.constant.LLMConstants.IMAGE_MESSAGES;

import com.bytechef.component.definition.Parameters;
import com.bytechef.component.definition.TypeReference;
import java.util.List;
import org.springframework.ai.image.ImageGeneration;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;

/**
 * @author Marko Kriskovic
 */
@FunctionalInterface
public interface ImageModel {

    enum ResponseFormat {

        URL("url"), B64_JSON("b64_json");

        private final String value;

        ResponseFormat(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum Style {

        VIVID("vivid"), NATURAL("natural");

        private final String value;

        Style(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    enum Quality {
        STANDARD("standard"),
        HD("hd");

        private final String value;

        Quality(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    org.springframework.ai.image.ImageModel createImageModel(
        Parameters inputParameters, Parameters connectionParameters);

    default Object getResponse(Parameters inputParameters, Parameters connectionParameters) {
        org.springframework.ai.image.ImageModel imageModel = createImageModel(inputParameters, connectionParameters);

        List<org.springframework.ai.image.ImageMessage> messages = getMessages(inputParameters);

        ImageResponse response = imageModel.call(new ImagePrompt(messages));

        ImageGeneration result = response.getResult();

        return result.getOutput();
    }

    private List<org.springframework.ai.image.ImageMessage> getMessages(Parameters inputParameters) {
        List<ImageMessage> imageMessages = inputParameters.getList(IMAGE_MESSAGES, new TypeReference<>() {});

        return imageMessages.stream()
            .map(messageRecord -> new org.springframework.ai.image.ImageMessage(
                messageRecord.content(), messageRecord.weight()))
            .toList();
    }

    record ImageMessage(String content, Float weight) {
    }
}
