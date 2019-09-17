package com.lambdaschool.school.controller;

import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.model.ErrorDetail;
import com.lambdaschool.school.model.Student;
import com.lambdaschool.school.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController
{
    @Autowired
    private StudentService studentService;

    // Please note there is no way to add students to course yet!

    // localhost:2019/students/students -- add paging 3 data on 1 page
    // localhost:2009/students/students/sort=studname,desc
    @GetMapping(value = "/students", produces = {"application/json"})
    public ResponseEntity<?> listAllStudents(
            @PageableDefault(page = 0,
                    size = 3)
                    Pageable pageable)
    {
        List<Student> myStudents = studentService.findAll(pageable);
        return new ResponseEntity<>(myStudents, HttpStatus.OK);
    }

    // localhost:2019/students/allstudents
    @GetMapping(value = "allstudents", produces = {"application/json"})
    public ResponseEntity<?> reallListAllStudents()
    {
        List<Student> myStudents = studentService.findAll(Pageable.unpaged());
        return new ResponseEntity<>(myStudents, HttpStatus.OK);
    }

    // localhost:2019/students/student/{studentid}
    @ApiOperation(value = "Return a student associated with the course id", response = Course.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Student by student-id Found", response = Course.class),
            @ApiResponse(code = 404, message = "Course by student-id Not Found", response = ErrorDetail.class)
    })
    @GetMapping(value = "/Student/{StudentId}",
            produces = {"application/json"})
    public ResponseEntity<?> getStudentById(
            @ApiParam(value = "Student Id", required = true, example = "1")
            @PathVariable
                    long StudentId)
    {
        Student r = studentService.findStudentById(StudentId);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }


    @GetMapping(value = "/student/namelike/{name}",
            produces = {"application/json"})
    public ResponseEntity<?> getStudentByNameContaining(
            @PathVariable String name)
    {
        List<Student> myStudents = studentService.findStudentByNameLike(name);
        return new ResponseEntity<>(myStudents, HttpStatus.OK);
    }

    // localhost:2019/students/student -- POST
    @ApiOperation(value = "Creates a new student.", notes = "The newly created student-id will be sent in the location header", response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Student Successfully Created", response = void.class),
            @ApiResponse(code = 500, message = "Error creating student", response = ErrorDetail.class)
    })
    @PostMapping(value = "/student",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewStudent(@Valid
                                           @RequestBody
                                                   Student newStudent) throws URISyntaxException
    {
        newStudent = studentService.save(newStudent);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newStudentURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Studentid}").buildAndExpand(newStudent.getStudid()).toUri();
        responseHeaders.setLocation(newStudentURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @PutMapping(value = "/Student/{Studentid}")
    public ResponseEntity<?> updateStudent(
            @RequestBody
                    Student updateStudent,
            @PathVariable
                    long Studentid)
    {
        studentService.update(updateStudent, Studentid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/Student/{Studentid}")
    public ResponseEntity<?> deleteStudentById(
            @PathVariable
                    long Studentid)
    {
        studentService.delete(Studentid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
