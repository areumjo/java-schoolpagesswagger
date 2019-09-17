# StudentControllerApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**addNewStudentUsingPOST**](StudentControllerApi.md#addNewStudentUsingPOST) | **POST** /students/student | Creates a new student.
[**deleteStudentByIdUsingDELETE**](StudentControllerApi.md#deleteStudentByIdUsingDELETE) | **DELETE** /students/Student/{Studentid} | deleteStudentById
[**getStudentByIdUsingGET**](StudentControllerApi.md#getStudentByIdUsingGET) | **GET** /students/Student/{StudentId} | Return a student associated with the course id
[**getStudentByNameContainingUsingGET**](StudentControllerApi.md#getStudentByNameContainingUsingGET) | **GET** /students/student/namelike/{name} | getStudentByNameContaining
[**listAllStudentsUsingGET**](StudentControllerApi.md#listAllStudentsUsingGET) | **GET** /students/students | listAllStudents
[**reallListAllStudentsUsingGET**](StudentControllerApi.md#reallListAllStudentsUsingGET) | **GET** /students/allstudents | reallListAllStudents
[**updateStudentUsingPUT**](StudentControllerApi.md#updateStudentUsingPUT) | **PUT** /students/Student/{Studentid} | updateStudent


## **addNewStudentUsingPOST**

Creates a new student.

The newly created student-id will be sent in the location header

### Example
```bash
 addNewStudentUsingPOST
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **newStudent** | [**Student**](Student.md) | newStudent |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **deleteStudentByIdUsingDELETE**

deleteStudentById

### Example
```bash
 deleteStudentByIdUsingDELETE Studentid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **studentid** | **integer** | Studentid |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **getStudentByIdUsingGET**

Return a student associated with the course id

### Example
```bash
 getStudentByIdUsingGET StudentId=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **studentId** | **integer** | Student Id |

### Return type

[**Course**](Course.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **getStudentByNameContainingUsingGET**

getStudentByNameContaining

### Example
```bash
 getStudentByNameContainingUsingGET name=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **string** | name |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **listAllStudentsUsingGET**

listAllStudents

### Example
```bash
 listAllStudentsUsingGET
```

### Parameters
This endpoint does not need any parameter.

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **reallListAllStudentsUsingGET**

reallListAllStudents

### Example
```bash
 reallListAllStudentsUsingGET
```

### Parameters
This endpoint does not need any parameter.

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **updateStudentUsingPUT**

updateStudent

### Example
```bash
 updateStudentUsingPUT Studentid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **studentid** | **integer** | Studentid |
 **updateStudent** | [**Student**](Student.md) | updateStudent |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

