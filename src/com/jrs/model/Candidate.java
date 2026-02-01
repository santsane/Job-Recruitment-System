package com.jrs.model;

public class Candidate extends User {
    private String resumeLink;

    public Candidate(int id, String name, String email, String resumeLink) {
        super(id, name, email);
        this.resumeLink = resumeLink;
    }

    @Override
    public String getRole() {
        return "CANDIDATE";
    }

    // 2nd abstract method
    @Override
    public String getPermissions() {
        return "VIEW_JOBS, APPLY_TO_JOBS, UPDATE_PROFILE";
    }

    public String getResumeLink() { return resumeLink; }
}