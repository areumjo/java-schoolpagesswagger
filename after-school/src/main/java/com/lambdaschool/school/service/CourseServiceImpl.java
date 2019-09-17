package com.lambdaschool.school.service;

import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.repository.CourseRepository;
import com.lambdaschool.school.view.CountStudentsInCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;

@Service(value = "courseService")
public class CourseServiceImpl implements CourseService
{
    @Autowired
    private CourseRepository courserepos;

    @Override
    public ArrayList<Course> findAll(Pageable pageable)
    {
        ArrayList<Course> list = new ArrayList<>();
        courserepos.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public ArrayList<CountStudentsInCourses> getCountStudentsInCourse()
    {
        return courserepos.getCountStudentsInCourse();
    }

    @Transactional
    @Override
    public void delete(long id) throws EntityNotFoundException
    {
        if (courserepos.findById(id).isPresent())
        {
            courserepos.deleteCourseFromStudcourses(id);
            courserepos.deleteById(id);
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Override
    public Course findCourseById(long id) {
        return courserepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Transactional
    @Override
    public Course save(Course course) {
        Course newCourse = new Course();
        newCourse.setCoursename(course.getCoursename());
        return courserepos.save(newCourse);
    }

    @Override
    public Course update(Course course, long id) {
        Course currentCourse = courserepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        if (course.getCoursename() != null)
        {
            currentCourse.setCoursename(course.getCoursename());
        }
        return courserepos.save(currentCourse);
    }
}
