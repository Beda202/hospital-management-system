package com.hospital.hms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ProblemDetail handleUserNotFoundException(UserNotFoundException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND , ex.getMessage()) ;
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ProblemDetail handleInvalidPasswordException(InvalidPasswordException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST , ex.getMessage()) ;
    }

    @ExceptionHandler(UserNameAlreadyExistException.class)
    public ProblemDetail handleUserNameAlreadyExistException(UserNameAlreadyExistException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST , ex.getMessage()) ;
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ProblemDetail handleEmailAlreadyExistException(EmailAlreadyExistException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST , ex.getMessage()) ;
    }

    @ExceptionHandler(PasswordEmptyException.class)
    public ProblemDetail handlePasswordEmptyException(PasswordEmptyException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST , ex.getMessage()) ;
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ProblemDetail handlePatientNotFoundException(PatientNotFoundException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND , ex.getMessage()) ;
    }

    @ExceptionHandler(NationalIDAlreadyExists.class)
    public ProblemDetail handleNationalIDAlreadyExists(NationalIDAlreadyExists ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST , ex.getMessage()) ;
    }




}
