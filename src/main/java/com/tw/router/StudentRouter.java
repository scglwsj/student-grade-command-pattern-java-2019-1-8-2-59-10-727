package com.tw.router;

import com.tw.application.service.StudentApplicationService;
import com.tw.utils.exception.CreateStudentInputException;
import com.tw.router.viewObject.CreateStudentRequest;

import javax.inject.Inject;

public class StudentRouter {
   private StudentApplicationService studentApplicationService;

   @Inject
    public StudentRouter(StudentApplicationService studentApplicationService) {
        this.studentApplicationService = studentApplicationService;
    }

    public void create(String in) throws CreateStudentInputException {
        CreateStudentRequest request = new CreateStudentRequest(in);
        studentApplicationService.create(request.getStudentModel(), request.getScores());
    }
}
