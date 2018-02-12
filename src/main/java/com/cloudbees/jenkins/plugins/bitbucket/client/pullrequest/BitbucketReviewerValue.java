package com.cloudbees.jenkins.plugins.bitbucket.client.pullrequest;

import com.cloudbees.jenkins.plugins.bitbucket.api.BitbucketReviewer;

public class BitbucketReviewerValue implements BitbucketReviewer {
    private User user;
    private boolean approved;

    @Override
    public boolean getApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    @Override
    public String getReviewerLogin() {
        return user.getUsername();
    }

    public static class User {
        private String username;

        public User() {}
        public User(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

    }
}
