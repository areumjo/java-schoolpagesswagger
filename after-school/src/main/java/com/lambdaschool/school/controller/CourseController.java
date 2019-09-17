package com.lambdaschool.school.controller;

import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.ErrorDetail;
import com.lambdaschool.school.model.Student;
import com.lambdaschool.school.service.CourseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController
{
    @Autowired
    private CourseService courseService;

    // localhost:2019/courses/courses
    // localhost:2019/courses/courses/?page=0&size=1 <== showing only one datapoint (courseid = 1)
    // localhost:2019/courses/courses/?sort=students,desc&sort=coursename
    @ApiOperation(value = "Returns all 3 courses on each page", response = Course.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query", value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page"),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query", value = "Sorting criteria in the format: property(,asc|desc). " + "Default sort order is ascending. " + "Multiple sort criteria are supported.")
    })
    @GetMapping(value = "/courses", produces = {"application/json"})
    public ResponseEntity<?> listAllCourses(
            @PageableDefault(page = 0,
                    size = 3)
                    Pageable pageable)
    {
        ArrayList<Course> myCourses = courseService.findAll(pageable);
        return new ResponseEntity<>(myCourses, HttpStatus.OK);
    }

    // localhost:2019/courses/allcourses
    @GetMapping(value = "allcourses", produces = {"application/json"})
    public ResponseEntity<?> reallListAllCourse()
    {
        List<Course> myCourses = courseService.findAll(Pageable.unpaged());
        return new ResponseEntity<>(myCourses, HttpStatus.OK);
    }

    // customize swagger
    // localhost:2019/course/course/{courseid}
    @ApiOperation(value = "Return a course associated with the course id", response = Course.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Course by course-id Found", response = Course.class),
            @ApiResponse(code = 404, message = "Course by course-id Not Found", response = ErrorDetail.class)
    })
    @GetMapping(value = "/course/{courseid}",
            produces = {"application/json"})
    public ResponseEntity<?> getCourseById(
            @ApiParam(value = "Course id", required = true, example = "1")
            @PathVariable long courseid)
    {
        Course cour = courseService.findCourseById(courseid);
        return new ResponseEntity<>(cour, HttpStatus.OK);
    }

    @GetMapping(value = "/studcount", produces = {"application/json"})
    public ResponseEntity<?> getCountStudentsInCourses()
    {
        return new ResponseEntity<>(courseService.getCountStudentsInCourse(), HttpStatus.OK);
    }

    @DeleteMapping("/courses/{courseid}")
    public ResponseEntity<?> deleteCourseById(@PathVariable long courseid)
    {
        courseService.delete(courseid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // localhost:2019/courses/course -- post
    @ApiOperation(value = "Creates a new Course.", notes = "The newly created course id will be sent in the location header", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Course Successfully Created", response = void.class),
            @ApiResponse(code = 500, message = "Error creating course", response = ErrorDetail.class)
    })
    @PostMapping(value = "/course",
                consumes = {"application/json"},
                produces = {"application/json"})
    public ResponseEntity<?> addNewCourse(@Valid @RequestBody Course newCourse) throws URISyntaxException
    {
        newCourse = courseService.save(newCourse);
        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCourseURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{courseid}").buildAndExpand(newCourse.getCourseid()).toUri();
        responseHeaders.setLocation(newCourseURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    // localhost:2019/courses/course -- put
    @PutMapping(value = "/course/{courseid}")
    public ResponseEntity<?> updateCourse(@RequestBody Course updateCourse,
                                          @PathVariable long courseid)
    {
        courseService.update(updateCourse, courseid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
