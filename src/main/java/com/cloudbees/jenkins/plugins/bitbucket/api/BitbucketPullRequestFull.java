package com.cloudbees.jenkins.plugins.bitbucket.api;

import java.util.List;

public interface BitbucketPullRequestFull extends BitbucketPullRequest {

    List<Participant> getParticipants();
}
