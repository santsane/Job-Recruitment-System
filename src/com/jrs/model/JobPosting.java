package com.jrs.model;

public class JobPosting {
    private int id;
    private String title;
    private String description;
    private Recruiter recruiter; // COMPOSITION: Job "has a" Recruiter

    public JobPosting(int id, String title, String description, Recruiter recruiter) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.recruiter = recruiter;
    }

    // Getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Recruiter getRecruiter() { return recruiter; }
}