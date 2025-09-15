package org.gowtham.job_management_admin_interface_backend.Service;

import org.gowtham.job_management_admin_interface_backend.Model.JobPost;
import org.gowtham.job_management_admin_interface_backend.Repository.JobPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostServiceImpl implements JobPostService {

    @Autowired
    private JobPostRepo jobPostRepo;

    @Override
    public JobPost createJobPost(JobPost newJobPost) {
        return  jobPostRepo.save(newJobPost);
    }

    @Override
    public List<JobPost> getAllJobPosts() {
        return jobPostRepo.findAll();
    }
}
