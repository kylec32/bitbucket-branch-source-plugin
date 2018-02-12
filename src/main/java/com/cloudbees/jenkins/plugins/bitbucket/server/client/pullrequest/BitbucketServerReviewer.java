package com.cloudbees.jenkins.plugins.bitbucket.server.client.pullrequest;

import com.cloudbees.jenkins.plugins.bitbucket.api.BitbucketReviewer;

public class BitbucketServerReviewer implements BitbucketReviewer {
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
        return user.getName();
    }

    public static class User {
        private String name;

        public User() {}
        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
