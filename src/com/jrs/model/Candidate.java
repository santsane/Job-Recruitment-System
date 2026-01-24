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

    public String getResumeLink() { return resumeLink; }
}