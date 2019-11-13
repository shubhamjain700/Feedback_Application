package com.appsquadz.feedback_application;

public class Faculty {

    private String facultyid;
    private String facultyName;
    private String facultynumber;
    private String facultyMail;


    public Faculty(String facultyid, String facultyName, String facultynumber,String facultyMail) {
        this.facultyid = facultyid;
        this.facultyName = facultyName;
        this.facultynumber = facultynumber;
        this.facultyMail=facultyMail;
    }

    public String getFacultyid() {
        return facultyid;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public String getFacultynumber() {
        return facultynumber;
    }

    public String getFacultyMail() {
        return facultyMail;
    }



}
