package com.cloudbees.jenkins.plugins.bitbucket.api;


public interface BitbucketReviewer {

    boolean getApproved();

    String getReviewerLogin();
}