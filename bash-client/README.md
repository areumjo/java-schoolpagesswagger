# Java Frameworks Bash client

## Overview
This is a Bash client script for accessing Java Frameworks service.

The script uses cURL underneath for making all REST calls.

## Usage

```shell
# Make sure the script has executable rights
$ chmod u+x 

# Print the list of operations available on the service
$ ./ -h

# Print the service description
$ ./ --about

# Print detailed information about specific operation
$ ./ <operationId> -h

# Make GET request
./ --host http://<hostname>:<port> --accept xml <operationId> <queryParam1>=<value1> <header_key1>:<header_value2>

# Make GET request using arbitrary curl options (must be passed before <operationId>) to an SSL service using username:password
 -k -sS --tlsv1.2 --host https://<hostname> -u <user>:<password> --accept xml <operationId> <queryParam1>=<value1> <header_key1>:<header_value2>

# Make POST request
$ echo '<body_content>' |  --host <hostname> --content-type json <operationId> -

# Make POST request with simple JSON content, e.g.:
# {
#   "key1": "value1",
#   "key2": "value2",
#   "key3": 23
# }
$ echo '<body_content>' |  --host <hostname> --content-type json <operationId> key1==value1 key2=value2 key3:=23 -

# Preview the cURL command without actually executing it
$  --host http://<hostname>:<port> --dry-run <operationid>

```

## Docker image
You can easily create a Docker image containing a preconfigured environment
for using the REST Bash client including working autocompletion and short
welcome message with basic instructions, using the generated Dockerfile:

```shell
docker build -t my-rest-client .
docker run -it my-rest-client
```

By default you will be logged into a Zsh environment which has much more
advanced auto completion, but you can switch to Bash, where basic autocompletion
is also available.

## Shell completion

### Bash
The generated bash-completion script can be either directly loaded to the current Bash session using:

```shell
source .bash-completion
```

Alternatively, the script can be copied to the `/etc/bash-completion.d` (or on OSX with Homebrew to `/usr/local/etc/bash-completion.d`):

```shell
sudo cp .bash-completion /etc/bash-completion.d/
```

#### OS X
On OSX you might need to install bash-completion using Homebrew:
```shell
brew install bash-completion
```
and add the following to the `~/.bashrc`:

```shell
if [ -f $(brew --prefix)/etc/bash_completion ]; then
  . $(brew --prefix)/etc/bash_completion
fi
```

### Zsh
In Zsh, the generated `_` Zsh completion file must be copied to one of the folders under `$FPATH` variable.


## Documentation for API Endpoints

All URIs are relative to **

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*CourseControllerApi* | [**addNewCourseUsingPOST**](docs/CourseControllerApi.md#addnewcourseusingpost) | **POST** /courses/course | Creates a new Course.
*CourseControllerApi* | [**deleteCourseByIdUsingDELETE**](docs/CourseControllerApi.md#deletecoursebyidusingdelete) | **DELETE** /courses/courses/{courseid} | deleteCourseById
*CourseControllerApi* | [**getCountStudentsInCoursesUsingGET**](docs/CourseControllerApi.md#getcountstudentsincoursesusingget) | **GET** /courses/studcount | getCountStudentsInCourses
*CourseControllerApi* | [**getCourseByIdUsingGET**](docs/CourseControllerApi.md#getcoursebyidusingget) | **GET** /courses/course/{courseid} | Return a course associated with the course id
*CourseControllerApi* | [**listAllCoursesUsingGET**](docs/CourseControllerApi.md#listallcoursesusingget) | **GET** /courses/courses | Returns all 3 courses on each page
*CourseControllerApi* | [**reallListAllCourseUsingGET**](docs/CourseControllerApi.md#realllistallcourseusingget) | **GET** /courses/allcourses | reallListAllCourse
*CourseControllerApi* | [**updateCourseUsingPUT**](docs/CourseControllerApi.md#updatecourseusingput) | **PUT** /courses/course/{courseid} | updateCourse
*StudentControllerApi* | [**addNewStudentUsingPOST**](docs/StudentControllerApi.md#addnewstudentusingpost) | **POST** /students/student | Creates a new student.
*StudentControllerApi* | [**deleteStudentByIdUsingDELETE**](docs/StudentControllerApi.md#deletestudentbyidusingdelete) | **DELETE** /students/Student/{Studentid} | deleteStudentById
*StudentControllerApi* | [**getStudentByIdUsingGET**](docs/StudentControllerApi.md#getstudentbyidusingget) | **GET** /students/Student/{StudentId} | Return a student associated with the course id
*StudentControllerApi* | [**getStudentByNameContainingUsingGET**](docs/StudentControllerApi.md#getstudentbynamecontainingusingget) | **GET** /students/student/namelike/{name} | getStudentByNameContaining
*StudentControllerApi* | [**listAllStudentsUsingGET**](docs/StudentControllerApi.md#listallstudentsusingget) | **GET** /students/students | listAllStudents
*StudentControllerApi* | [**reallListAllStudentsUsingGET**](docs/StudentControllerApi.md#realllistallstudentsusingget) | **GET** /students/allstudents | reallListAllStudents
*StudentControllerApi* | [**updateStudentUsingPUT**](docs/StudentControllerApi.md#updatestudentusingput) | **PUT** /students/Student/{Studentid} | updateStudent


## Documentation For Models

 - [Course](docs/Course.md)
 - [ErrorDetail](docs/ErrorDetail.md)
 - [Instructor](docs/Instructor.md)
 - [Student](docs/Student.md)
 - [ValidationError](docs/ValidationError.md)


## Documentation For Authorization

 All endpoints do not require authorization.

