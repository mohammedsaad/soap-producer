package com.example.soap;

import com.example.courses.*;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CourseDetailsEndpoint {

    CourseService service;

    public CourseDetailsEndpoint(CourseService service) {
        this.service = service;
    }

    //method
    //input-GetCourseDetailsRequest
    //output-GetCourseDetailsResponse
    @PayloadRoot(namespace = "http://example.com/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request)throws CourseNotFoundException {
        GetCourseDetailsResponse courseDetailsResponse = new GetCourseDetailsResponse();
        CourseDetails courseDetails = service.findById(request.getId());
        courseDetailsResponse.setCourseDetails(courseDetails);
        return courseDetailsResponse;
    }

    @PayloadRoot(namespace = "http://example.com/courses", localPart = "GetAllCoursesDetailsRequest")
    @ResponsePayload
    public GetAllCoursesDetailsResponse processCourseDetailsRequest(@RequestPayload GetAllCoursesDetailsRequest request) {
        GetAllCoursesDetailsResponse coursesDetailsResponse = new GetAllCoursesDetailsResponse();
        coursesDetailsResponse.getCourseDetails().addAll(service.getCourses());
        return coursesDetailsResponse;
    }

    @PayloadRoot(namespace = "http://example.com/courses", localPart = "DeleteCourseRequest")
    @ResponsePayload
    public DeleteCourseResponse processCourseDetailsRequest(@RequestPayload DeleteCourseRequest request) {
        DeleteCourseResponse deleteCourseResponse = new DeleteCourseResponse();
        Status status = service.deleteCourse(request.getId());
        deleteCourseResponse.setStatus(status);
        return deleteCourseResponse;
    }

}


