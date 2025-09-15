package org.gowtham.job_management_admin_interface_backend.Service;


import org.gowtham.job_management_admin_interface_backend.Model.JobPost;

import java.util.List;

public interface JobPostService {

    JobPost createJobPost(JobPost newJobPost);

    List<JobPost> getAllJobPosts();
}
