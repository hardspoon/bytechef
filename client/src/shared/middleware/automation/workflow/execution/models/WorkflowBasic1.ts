/* tslint:disable */
/* eslint-disable */
/**
 * The Automation Execution Internal API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

import { mapValues } from '../runtime';
/**
 * The blueprint that describe the execution of a job.
 * @export
 * @interface WorkflowBasic1
 */
export interface WorkflowBasic1 {
    /**
     * The created by.
     * @type {string}
     * @memberof WorkflowBasic1
     */
    readonly createdBy?: string;
    /**
     * The created date.
     * @type {Date}
     * @memberof WorkflowBasic1
     */
    readonly createdDate?: Date;
    /**
     * The description of a workflow.
     * @type {string}
     * @memberof WorkflowBasic1
     */
    description?: string;
    /**
     * The id of a workflow.
     * @type {string}
     * @memberof WorkflowBasic1
     */
    readonly id?: string;
    /**
     * The descriptive name for the workflow
     * @type {string}
     * @memberof WorkflowBasic1
     */
    readonly label?: string;
    /**
     * The last modified by.
     * @type {string}
     * @memberof WorkflowBasic1
     */
    readonly lastModifiedBy?: string;
    /**
     * The last modified date.
     * @type {Date}
     * @memberof WorkflowBasic1
     */
    readonly lastModifiedDate?: Date;
    /**
     * 
     * @type {number}
     * @memberof WorkflowBasic1
     */
    version?: number;
}

/**
 * Check if a given object implements the WorkflowBasic1 interface.
 */
export function instanceOfWorkflowBasic1(value: object): value is WorkflowBasic1 {
    return true;
}

export function WorkflowBasic1FromJSON(json: any): WorkflowBasic1 {
    return WorkflowBasic1FromJSONTyped(json, false);
}

export function WorkflowBasic1FromJSONTyped(json: any, ignoreDiscriminator: boolean): WorkflowBasic1 {
    if (json == null) {
        return json;
    }
    return {
        
        'createdBy': json['createdBy'] == null ? undefined : json['createdBy'],
        'createdDate': json['createdDate'] == null ? undefined : (new Date(json['createdDate'])),
        'description': json['description'] == null ? undefined : json['description'],
        'id': json['id'] == null ? undefined : json['id'],
        'label': json['label'] == null ? undefined : json['label'],
        'lastModifiedBy': json['lastModifiedBy'] == null ? undefined : json['lastModifiedBy'],
        'lastModifiedDate': json['lastModifiedDate'] == null ? undefined : (new Date(json['lastModifiedDate'])),
        'version': json['__version'] == null ? undefined : json['__version'],
    };
}

export function WorkflowBasic1ToJSON(json: any): WorkflowBasic1 {
    return WorkflowBasic1ToJSONTyped(json, false);
}

export function WorkflowBasic1ToJSONTyped(value?: Omit<WorkflowBasic1, 'createdBy'|'createdDate'|'id'|'label'|'lastModifiedBy'|'lastModifiedDate'> | null, ignoreDiscriminator: boolean = false): any {
    if (value == null) {
        return value;
    }

    return {
        
        'description': value['description'],
        '__version': value['version'],
    };
}

