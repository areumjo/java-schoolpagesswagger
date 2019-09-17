# Project School Pages Swagger

A student that completes this project shows that they can:

## Introduction

## Instructions
Start with the school project - you can start with the project provided OR as a stretch goal, use your previous school project!

* Add custom Swagger documenation for each endpoint exposed in the application
  * include custom message for error conditions
  * include messages for parameters, if any.

* Add custom Swagger documentation to the model for Student, Course, and Instructor

* Make pageable and sortable the following endpoints
  * /courses/coures
  * /students/students
  * set the default number to show to 3 for each endpoint

## Stretch Goals
* Add endpoints to create, update, delete an instructor.
  * Fully document with custom Swagger

* Add endpoints to add, delete a student from a course.
  * Fully document with custom Swagger

* Add User Authentication using OAuth2 to the Java-School Application

* After adding User Authentication, Add Endpoints to create, read, update, delete a user.
  * Fully document with custom Swagger


---
# Endpoint Document
## Course
### Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**courseid** | **integer** |  | [default to null]
**coursename** | **string** |  | [default to null]
**instructor** | [**Instructor**](Instructor.md) |  | [optional] [default to null]
**students** | [**array[Student]**](Student.md) |  | [optional] [default to null]

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)


## CourseControllerApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**addNewCourseUsingPOST**](CourseControllerApi.md#addNewCourseUsingPOST) | **POST** /courses/course | Creates a new Course.
[**deleteCourseByIdUsingDELETE**](CourseControllerApi.md#deleteCourseByIdUsingDELETE) | **DELETE** /courses/courses/{courseid} | deleteCourseById
[**getCountStudentsInCoursesUsingGET**](CourseControllerApi.md#getCountStudentsInCoursesUsingGET) | **GET** /courses/studcount | getCountStudentsInCourses
[**getCourseByIdUsingGET**](CourseControllerApi.md#getCourseByIdUsingGET) | **GET** /courses/course/{courseid} | Return a course associated with the course id
[**listAllCoursesUsingGET**](CourseControllerApi.md#listAllCoursesUsingGET) | **GET** /courses/courses | Returns all 3 courses on each page
[**reallListAllCourseUsingGET**](CourseControllerApi.md#reallListAllCourseUsingGET) | **GET** /courses/allcourses | reallListAllCourse
[**updateCourseUsingPUT**](CourseControllerApi.md#updateCourseUsingPUT) | **PUT** /courses/course/{courseid} | updateCourse


## **addNewCourseUsingPOST**

Creates a new Course.

The newly created course id will be sent in the location header

### Example
```bash
 addNewCourseUsingPOST
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **newCourse** | [**Course**](Course.md) | newCourse |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **deleteCourseByIdUsingDELETE**

deleteCourseById

### Example
```bash
 deleteCourseByIdUsingDELETE courseid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **courseid** | **integer** | courseid |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **getCountStudentsInCoursesUsingGET**

getCountStudentsInCourses

### Example
```bash
 getCountStudentsInCoursesUsingGET
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

## **getCourseByIdUsingGET**

Return a course associated with the course id

### Example
```bash
 getCourseByIdUsingGET courseid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **courseid** | **integer** | Course id |

### Return type

[**Course**](Course.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **listAllCoursesUsingGET**

Returns all 3 courses on each page

### Example
```bash
 listAllCoursesUsingGET  page=value  size=value  Specify as:  sort=value1 sort=value2 sort=...
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | [**Object**](.md) | Results page you want to retrieve (0..N) | [optional]
 **size** | [**Object**](.md) | Number of records per page | [optional]
 **sort** | [**array[string]**](string.md) | Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported. | [optional]

### Return type

[**array[Course]**](Course.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **reallListAllCourseUsingGET**

reallListAllCourse

### Example
```bash
 reallListAllCourseUsingGET
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

## **updateCourseUsingPUT**

updateCourse

### Example
```bash
 updateCourseUsingPUT courseid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **courseid** | **integer** | courseid |
 **updateCourse** | [**Course**](Course.md) | updateCourse |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)


