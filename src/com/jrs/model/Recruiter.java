package com.jrs.model;

public class Recruiter extends User {
    private String companyName;

    public Recruiter(int id, String name, String email, String companyName) {
        super(id, name, email);
        this.companyName = companyName;
    }

    @Override
    public String getRole() {
        return "RECRUITER";
    }

    // 2nd abstract method
    @Override
    public String getPermissions() {
        return "POST_JOBS, VIEW_APPLICANTS, MANAGE_COMPANY";
    }

    public String getCompanyName() { return companyName; }
}