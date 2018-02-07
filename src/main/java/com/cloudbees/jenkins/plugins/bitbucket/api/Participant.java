package com.cloudbees.jenkins.plugins.bitbucket.api;


public class Participant {
    private User user;
    private boolean approved;

    public boolean getApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

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