package com.student.rest.service;

import com.student.rest.response.basicresponsemsg;
import com.student.rest.response.studentrequestvo;

public interface studentservice {
   public basicresponsemsg savestudent(studentrequestvo studentrequestvo);

public basicresponsemsg getstudentbyid(studentrequestvo studentrequestvo);

public basicresponsemsg getallstudent(studentrequestvo studentrequestvo);

public basicresponsemsg updatestudentbyid(studentrequestvo studentrequestvo);

public basicresponsemsg deletebyid(studentrequestvo studentrequestvo);
}
