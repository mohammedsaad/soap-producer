package com.example.soap;

import com.example.courses.CourseDetails;
import com.example.courses.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private List <CourseDetails> courses = new ArrayList <>();


    public CourseService() {
        populateCourses();
    }

    private void populateCourses() {

        CourseDetails course1 = new CourseDetails();
        course1.setId(1);
        course1.setDescription("new Course");
        course1.setName("java new course");
        courses.add(course1);

        CourseDetails course2 = new CourseDetails();
        course2.setId(2);
        course2.setDescription("spring boot");
        course2.setName("spring boot course");
        courses.add(course2);

        CourseDetails course3 = new CourseDetails();
        course3.setId(3);
        course3.setDescription("Rest Api");
        course3.setName("Rest Api course");
        courses.add(course3);

        CourseDetails course4 = new CourseDetails();
        course4.setId(4);
        course4.setDescription("Docker");
        course4.setName("Docker course");
        courses.add(course4);

    }

    public List <CourseDetails> getCourses() {
        return courses;
    }

    Status deleteCourse(int id) {
        for (CourseDetails course : courses) {
            if (course.getId() == id) {
                courses.remove(course);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

    public CourseDetails findById(int id) throws CourseNotFoundException {
        CourseDetails course = courses.stream()
                .filter(courseDetails -> courseDetails.getId() == id)
                .findFirst()
                .orElseThrow(() -> new CourseNotFoundException("Invalid course Id : " + id));
        return course;
    }
}