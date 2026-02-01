package com.jrs.model;

public class JobPosting {
    private int id;
    private String title;
    private String description;
    // Composition
    private Recruiter recruiter;

    public JobPosting(int id, String title, String description, Recruiter recruiter) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.recruiter = recruiter;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Recruiter getRecruiter() { return recruiter; }
    public void setRecruiter(Recruiter recruiter) { this.recruiter = recruiter; }

    // Concrete method for composition
    public void displayJobDetails() {
        System.out.println("Job: " + title + " | Posted by: " + recruiter.getName() + " from " + recruiter.getCompanyName());
    }
}