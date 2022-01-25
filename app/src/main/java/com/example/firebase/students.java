package com.example.firebase;

public class students {

    private String student_name;
    private String student_id;
    private String student_bankAccount;
    private String student_privacyCode;

    public students(){

    }

    public students(String student_name, String student_id, String student_bankAccount, String student_privacyCode) {
        this.student_name = student_name;
        this.student_id = student_id;
        this.student_bankAccount = student_bankAccount;
        this.student_privacyCode = student_privacyCode;
    }


    public String getStudent_name() {
        return student_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public String getStudent_bankAccount() {
        return student_bankAccount;
    }

    public String getStudent_privacyCode() {
        return student_privacyCode;
    }
}
