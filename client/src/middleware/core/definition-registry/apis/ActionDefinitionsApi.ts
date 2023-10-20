/* tslint:disable */
/* eslint-disable */
/**
 * Core Definition API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


import * as runtime from '../runtime';
import type {
  ActionDefinitionBasicModel,
  ActionDefinitionModel,
  ComponentOperationRequestModel,
  OptionModel,
  PropertyModel,
} from '../models';
import {
    ActionDefinitionBasicModelFromJSON,
    ActionDefinitionBasicModelToJSON,
    ActionDefinitionModelFromJSON,
    ActionDefinitionModelToJSON,
    ComponentOperationRequestModelFromJSON,
    ComponentOperationRequestModelToJSON,
    OptionModelFromJSON,
    OptionModelToJSON,
    PropertyModelFromJSON,
    PropertyModelToJSON,
} from '../models';

export interface GetComponentActionDefinitionRequest {
    componentName: string;
    componentVersion: number;
    actionName: string;
}

export interface GetComponentActionDefinitionsRequest {
    componentName: string;
    componentVersion: number;
}

export interface GetComponentActionEditorDescriptionRequest {
    componentName: string;
    componentVersion: number;
    actionName: string;
    componentOperationRequestModel?: ComponentOperationRequestModel;
}

export interface GetComponentActionOutputSchemaRequest {
    componentName: string;
    componentVersion: number;
    actionName: string;
    componentOperationRequestModel?: ComponentOperationRequestModel;
}

export interface GetComponentActionPropertyDynamicPropertiesRequest {
    componentName: string;
    componentVersion: number;
    actionName: string;
    propertyName: string;
    componentOperationRequestModel?: ComponentOperationRequestModel;
}

export interface GetComponentActionPropertyOptionsRequest {
    componentName: string;
    componentVersion: number;
    actionName: string;
    propertyName: string;
    searchText?: string;
    componentOperationRequestModel?: ComponentOperationRequestModel;
}

export interface GetComponentActionSampleOutputRequest {
    componentName: string;
    componentVersion: number;
    actionName: string;
    componentOperationRequestModel?: ComponentOperationRequestModel;
}

/**
 * 
 */
export class ActionDefinitionsApi extends runtime.BaseAPI {

    /**
     * Get an action definition of a component.
     * Get an action definition of a component
     */
    async getComponentActionDefinitionRaw(requestParameters: GetComponentActionDefinitionRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<ActionDefinitionModel>> {
        if (requestParameters.componentName === null || requestParameters.componentName === undefined) {
            throw new runtime.RequiredError('componentName','Required parameter requestParameters.componentName was null or undefined when calling getComponentActionDefinition.');
        }

        if (requestParameters.componentVersion === null || requestParameters.componentVersion === undefined) {
            throw new runtime.RequiredError('componentVersion','Required parameter requestParameters.componentVersion was null or undefined when calling getComponentActionDefinition.');
        }

        if (requestParameters.actionName === null || requestParameters.actionName === undefined) {
            throw new runtime.RequiredError('actionName','Required parameter requestParameters.actionName was null or undefined when calling getComponentActionDefinition.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/component-definitions/{componentName}/{componentVersion}/action-definitions/{actionName}`.replace(`{${"componentName"}}`, encodeURIComponent(String(requestParameters.componentName))).replace(`{${"componentVersion"}}`, encodeURIComponent(String(requestParameters.componentVersion))).replace(`{${"actionName"}}`, encodeURIComponent(String(requestParameters.actionName))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => ActionDefinitionModelFromJSON(jsonValue));
    }

    /**
     * Get an action definition of a component.
     * Get an action definition of a component
     */
    async getComponentActionDefinition(requestParameters: GetComponentActionDefinitionRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<ActionDefinitionModel> {
        const response = await this.getComponentActionDefinitionRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get a list of action definitions for a component.
     * Get a list of action definitions for a component
     */
    async getComponentActionDefinitionsRaw(requestParameters: GetComponentActionDefinitionsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<ActionDefinitionBasicModel>>> {
        if (requestParameters.componentName === null || requestParameters.componentName === undefined) {
            throw new runtime.RequiredError('componentName','Required parameter requestParameters.componentName was null or undefined when calling getComponentActionDefinitions.');
        }

        if (requestParameters.componentVersion === null || requestParameters.componentVersion === undefined) {
            throw new runtime.RequiredError('componentVersion','Required parameter requestParameters.componentVersion was null or undefined when calling getComponentActionDefinitions.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        const response = await this.request({
            path: `/component-definitions/{componentName}/{componentVersion}/action-definitions`.replace(`{${"componentName"}}`, encodeURIComponent(String(requestParameters.componentName))).replace(`{${"componentVersion"}}`, encodeURIComponent(String(requestParameters.componentVersion))),
            method: 'GET',
            headers: headerParameters,
            query: queryParameters,
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(ActionDefinitionBasicModelFromJSON));
    }

    /**
     * Get a list of action definitions for a component.
     * Get a list of action definitions for a component
     */
    async getComponentActionDefinitions(requestParameters: GetComponentActionDefinitionsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<ActionDefinitionBasicModel>> {
        const response = await this.getComponentActionDefinitionsRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get an action description shown in the editor.
     * Get an action description shown in the editor
     */
    async getComponentActionEditorDescriptionRaw(requestParameters: GetComponentActionEditorDescriptionRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<string>> {
        if (requestParameters.componentName === null || requestParameters.componentName === undefined) {
            throw new runtime.RequiredError('componentName','Required parameter requestParameters.componentName was null or undefined when calling getComponentActionEditorDescription.');
        }

        if (requestParameters.componentVersion === null || requestParameters.componentVersion === undefined) {
            throw new runtime.RequiredError('componentVersion','Required parameter requestParameters.componentVersion was null or undefined when calling getComponentActionEditorDescription.');
        }

        if (requestParameters.actionName === null || requestParameters.actionName === undefined) {
            throw new runtime.RequiredError('actionName','Required parameter requestParameters.actionName was null or undefined when calling getComponentActionEditorDescription.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/component-definitions/{componentName}/{componentVersion}/action-definitions/{actionName}/editor-description`.replace(`{${"componentName"}}`, encodeURIComponent(String(requestParameters.componentName))).replace(`{${"componentVersion"}}`, encodeURIComponent(String(requestParameters.componentVersion))).replace(`{${"actionName"}}`, encodeURIComponent(String(requestParameters.actionName))),
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: ComponentOperationRequestModelToJSON(requestParameters.componentOperationRequestModel),
        }, initOverrides);

        if (this.isJsonMime(response.headers.get('content-type'))) {
            return new runtime.JSONApiResponse<string>(response);
        } else {
            return new runtime.TextApiResponse(response) as any;
        }
    }

    /**
     * Get an action description shown in the editor.
     * Get an action description shown in the editor
     */
    async getComponentActionEditorDescription(requestParameters: GetComponentActionEditorDescriptionRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<string> {
        const response = await this.getComponentActionEditorDescriptionRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get an action output schema shown in the editor.
     * Get an action output schema shown in the editor
     */
    async getComponentActionOutputSchemaRaw(requestParameters: GetComponentActionOutputSchemaRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<PropertyModel>>> {
        if (requestParameters.componentName === null || requestParameters.componentName === undefined) {
            throw new runtime.RequiredError('componentName','Required parameter requestParameters.componentName was null or undefined when calling getComponentActionOutputSchema.');
        }

        if (requestParameters.componentVersion === null || requestParameters.componentVersion === undefined) {
            throw new runtime.RequiredError('componentVersion','Required parameter requestParameters.componentVersion was null or undefined when calling getComponentActionOutputSchema.');
        }

        if (requestParameters.actionName === null || requestParameters.actionName === undefined) {
            throw new runtime.RequiredError('actionName','Required parameter requestParameters.actionName was null or undefined when calling getComponentActionOutputSchema.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/component-definitions/{componentName}/{componentVersion}/action-definitions/{actionName}/output-schema`.replace(`{${"componentName"}}`, encodeURIComponent(String(requestParameters.componentName))).replace(`{${"componentVersion"}}`, encodeURIComponent(String(requestParameters.componentVersion))).replace(`{${"actionName"}}`, encodeURIComponent(String(requestParameters.actionName))),
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: ComponentOperationRequestModelToJSON(requestParameters.componentOperationRequestModel),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(PropertyModelFromJSON));
    }

    /**
     * Get an action output schema shown in the editor.
     * Get an action output schema shown in the editor
     */
    async getComponentActionOutputSchema(requestParameters: GetComponentActionOutputSchemaRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<PropertyModel>> {
        const response = await this.getComponentActionOutputSchemaRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get dynamic properties for an action property shown in the editor.
     * Get dynamic properties for an action property shown in the editor
     */
    async getComponentActionPropertyDynamicPropertiesRaw(requestParameters: GetComponentActionPropertyDynamicPropertiesRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<PropertyModel>>> {
        if (requestParameters.componentName === null || requestParameters.componentName === undefined) {
            throw new runtime.RequiredError('componentName','Required parameter requestParameters.componentName was null or undefined when calling getComponentActionPropertyDynamicProperties.');
        }

        if (requestParameters.componentVersion === null || requestParameters.componentVersion === undefined) {
            throw new runtime.RequiredError('componentVersion','Required parameter requestParameters.componentVersion was null or undefined when calling getComponentActionPropertyDynamicProperties.');
        }

        if (requestParameters.actionName === null || requestParameters.actionName === undefined) {
            throw new runtime.RequiredError('actionName','Required parameter requestParameters.actionName was null or undefined when calling getComponentActionPropertyDynamicProperties.');
        }

        if (requestParameters.propertyName === null || requestParameters.propertyName === undefined) {
            throw new runtime.RequiredError('propertyName','Required parameter requestParameters.propertyName was null or undefined when calling getComponentActionPropertyDynamicProperties.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/component-definitions/{componentName}/{componentVersion}/action-definitions/{actionName}/properties/{propertyName}/dynamic-properties`.replace(`{${"componentName"}}`, encodeURIComponent(String(requestParameters.componentName))).replace(`{${"componentVersion"}}`, encodeURIComponent(String(requestParameters.componentVersion))).replace(`{${"actionName"}}`, encodeURIComponent(String(requestParameters.actionName))).replace(`{${"propertyName"}}`, encodeURIComponent(String(requestParameters.propertyName))),
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: ComponentOperationRequestModelToJSON(requestParameters.componentOperationRequestModel),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(PropertyModelFromJSON));
    }

    /**
     * Get dynamic properties for an action property shown in the editor.
     * Get dynamic properties for an action property shown in the editor
     */
    async getComponentActionPropertyDynamicProperties(requestParameters: GetComponentActionPropertyDynamicPropertiesRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<PropertyModel>> {
        const response = await this.getComponentActionPropertyDynamicPropertiesRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get an action property options shown in the editor.
     * Get an action property options shown in the editor
     */
    async getComponentActionPropertyOptionsRaw(requestParameters: GetComponentActionPropertyOptionsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<Array<OptionModel>>> {
        if (requestParameters.componentName === null || requestParameters.componentName === undefined) {
            throw new runtime.RequiredError('componentName','Required parameter requestParameters.componentName was null or undefined when calling getComponentActionPropertyOptions.');
        }

        if (requestParameters.componentVersion === null || requestParameters.componentVersion === undefined) {
            throw new runtime.RequiredError('componentVersion','Required parameter requestParameters.componentVersion was null or undefined when calling getComponentActionPropertyOptions.');
        }

        if (requestParameters.actionName === null || requestParameters.actionName === undefined) {
            throw new runtime.RequiredError('actionName','Required parameter requestParameters.actionName was null or undefined when calling getComponentActionPropertyOptions.');
        }

        if (requestParameters.propertyName === null || requestParameters.propertyName === undefined) {
            throw new runtime.RequiredError('propertyName','Required parameter requestParameters.propertyName was null or undefined when calling getComponentActionPropertyOptions.');
        }

        const queryParameters: any = {};

        if (requestParameters.searchText !== undefined) {
            queryParameters['searchText'] = requestParameters.searchText;
        }

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/component-definitions/{componentName}/{componentVersion}/action-definitions/{actionName}/properties/{propertyName}/options`.replace(`{${"componentName"}}`, encodeURIComponent(String(requestParameters.componentName))).replace(`{${"componentVersion"}}`, encodeURIComponent(String(requestParameters.componentVersion))).replace(`{${"actionName"}}`, encodeURIComponent(String(requestParameters.actionName))).replace(`{${"propertyName"}}`, encodeURIComponent(String(requestParameters.propertyName))),
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: ComponentOperationRequestModelToJSON(requestParameters.componentOperationRequestModel),
        }, initOverrides);

        return new runtime.JSONApiResponse(response, (jsonValue) => jsonValue.map(OptionModelFromJSON));
    }

    /**
     * Get an action property options shown in the editor.
     * Get an action property options shown in the editor
     */
    async getComponentActionPropertyOptions(requestParameters: GetComponentActionPropertyOptionsRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<Array<OptionModel>> {
        const response = await this.getComponentActionPropertyOptionsRaw(requestParameters, initOverrides);
        return await response.value();
    }

    /**
     * Get an action sample output shown in the editor.
     * Get an action sample output shown in the editor
     */
    async getComponentActionSampleOutputRaw(requestParameters: GetComponentActionSampleOutputRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<runtime.ApiResponse<object>> {
        if (requestParameters.componentName === null || requestParameters.componentName === undefined) {
            throw new runtime.RequiredError('componentName','Required parameter requestParameters.componentName was null or undefined when calling getComponentActionSampleOutput.');
        }

        if (requestParameters.componentVersion === null || requestParameters.componentVersion === undefined) {
            throw new runtime.RequiredError('componentVersion','Required parameter requestParameters.componentVersion was null or undefined when calling getComponentActionSampleOutput.');
        }

        if (requestParameters.actionName === null || requestParameters.actionName === undefined) {
            throw new runtime.RequiredError('actionName','Required parameter requestParameters.actionName was null or undefined when calling getComponentActionSampleOutput.');
        }

        const queryParameters: any = {};

        const headerParameters: runtime.HTTPHeaders = {};

        headerParameters['Content-Type'] = 'application/json';

        const response = await this.request({
            path: `/component-definitions/{componentName}/{componentVersion}/action-definitions/{actionName}/sample-output`.replace(`{${"componentName"}}`, encodeURIComponent(String(requestParameters.componentName))).replace(`{${"componentVersion"}}`, encodeURIComponent(String(requestParameters.componentVersion))).replace(`{${"actionName"}}`, encodeURIComponent(String(requestParameters.actionName))),
            method: 'POST',
            headers: headerParameters,
            query: queryParameters,
            body: ComponentOperationRequestModelToJSON(requestParameters.componentOperationRequestModel),
        }, initOverrides);

        return new runtime.JSONApiResponse<any>(response);
    }

    /**
     * Get an action sample output shown in the editor.
     * Get an action sample output shown in the editor
     */
    async getComponentActionSampleOutput(requestParameters: GetComponentActionSampleOutputRequest, initOverrides?: RequestInit | runtime.InitOverrideFunction): Promise<object> {
        const response = await this.getComponentActionSampleOutputRaw(requestParameters, initOverrides);
        return await response.value();
    }

}
