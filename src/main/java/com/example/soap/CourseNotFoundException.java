package com.example.soap;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT)
public class CourseNotFoundException extends Exception {
    public CourseNotFoundException(String message) {
        super(message);
    }
}
