/* tslint:disable */
/* eslint-disable */
/**
 * The Core Configuration API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { exists, mapValues } from '../runtime';
import type { ControlTypeModel } from './ControlTypeModel';
import {
    ControlTypeModelFromJSON,
    ControlTypeModelFromJSONTyped,
    ControlTypeModelToJSON,
} from './ControlTypeModel';
import type { OptionModel } from './OptionModel';
import {
    OptionModelFromJSON,
    OptionModelFromJSONTyped,
    OptionModelToJSON,
} from './OptionModel';
import type { OptionsDataSourceModel } from './OptionsDataSourceModel';
import {
    OptionsDataSourceModelFromJSON,
    OptionsDataSourceModelFromJSONTyped,
    OptionsDataSourceModelToJSON,
} from './OptionsDataSourceModel';
import type { PropertyModel } from './PropertyModel';
import {
    PropertyModelFromJSON,
    PropertyModelFromJSONTyped,
    PropertyModelToJSON,
} from './PropertyModel';
import type { PropertyTypeModel } from './PropertyTypeModel';
import {
    PropertyTypeModelFromJSON,
    PropertyTypeModelFromJSONTyped,
    PropertyTypeModelToJSON,
} from './PropertyTypeModel';
import type { ValuePropertyModel } from './ValuePropertyModel';
import {
    ValuePropertyModelFromJSON,
    ValuePropertyModelFromJSONTyped,
    ValuePropertyModelToJSON,
} from './ValuePropertyModel';

/**
 * An array property type.
 * @export
 * @interface ArrayPropertyModel
 */
export interface ArrayPropertyModel extends ValuePropertyModel {
    /**
     * The property default value.
     * @type {Array<object>}
     * @memberof ArrayPropertyModel
     */
    defaultValue?: Array<object>;
    /**
     * The property sample value.
     * @type {Array<object>}
     * @memberof ArrayPropertyModel
     */
    exampleValue?: Array<object>;
    /**
     * Types of the array items.
     * @type {Array<PropertyModel>}
     * @memberof ArrayPropertyModel
     */
    items?: Array<PropertyModel>;
    /**
     * 
     * @type {number}
     * @memberof ArrayPropertyModel
     */
    maxItems?: number;
    /**
     * 
     * @type {number}
     * @memberof ArrayPropertyModel
     */
    minItems?: number;
    /**
     * If the array can contain multiple items.
     * @type {boolean}
     * @memberof ArrayPropertyModel
     */
    multipleValues?: boolean;
    /**
     * The list of valid property options.
     * @type {Array<OptionModel>}
     * @memberof ArrayPropertyModel
     */
    options?: Array<OptionModel>;
    /**
     * 
     * @type {OptionsDataSourceModel}
     * @memberof ArrayPropertyModel
     */
    optionsDataSource?: OptionsDataSourceModel;
}

/**
 * Check if a given object implements the ArrayPropertyModel interface.
 */
export function instanceOfArrayPropertyModel(value: object): boolean {
    let isInstance = true;

    return isInstance;
}

export function ArrayPropertyModelFromJSON(json: any): ArrayPropertyModel {
    return ArrayPropertyModelFromJSONTyped(json, false);
}

export function ArrayPropertyModelFromJSONTyped(json: any, ignoreDiscriminator: boolean): ArrayPropertyModel {
    if ((json === undefined) || (json === null)) {
        return json;
    }
    return {
        ...ValuePropertyModelFromJSONTyped(json, ignoreDiscriminator),
        'defaultValue': !exists(json, 'defaultValue') ? undefined : json['defaultValue'],
        'exampleValue': !exists(json, 'exampleValue') ? undefined : json['exampleValue'],
        'items': !exists(json, 'items') ? undefined : ((json['items'] as Array<any>).map(PropertyModelFromJSON)),
        'maxItems': !exists(json, 'maxItems') ? undefined : json['maxItems'],
        'minItems': !exists(json, 'minItems') ? undefined : json['minItems'],
        'multipleValues': !exists(json, 'multipleValues') ? undefined : json['multipleValues'],
        'options': !exists(json, 'options') ? undefined : ((json['options'] as Array<any>).map(OptionModelFromJSON)),
        'optionsDataSource': !exists(json, 'optionsDataSource') ? undefined : OptionsDataSourceModelFromJSON(json['optionsDataSource']),
    };
}

export function ArrayPropertyModelToJSON(value?: ArrayPropertyModel | null): any {
    if (value === undefined) {
        return undefined;
    }
    if (value === null) {
        return null;
    }
    return {
        ...ValuePropertyModelToJSON(value),
        'defaultValue': value.defaultValue,
        'exampleValue': value.exampleValue,
        'items': value.items === undefined ? undefined : ((value.items as Array<any>).map(PropertyModelToJSON)),
        'maxItems': value.maxItems,
        'minItems': value.minItems,
        'multipleValues': value.multipleValues,
        'options': value.options === undefined ? undefined : ((value.options as Array<any>).map(OptionModelToJSON)),
        'optionsDataSource': OptionsDataSourceModelToJSON(value.optionsDataSource),
    };
}

