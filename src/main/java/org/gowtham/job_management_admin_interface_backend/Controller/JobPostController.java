package org.gowtham.job_management_admin_interface_backend.Controller;


import org.gowtham.job_management_admin_interface_backend.DTO.ErrorResponseDTO;
import org.gowtham.job_management_admin_interface_backend.DTO.JobPostRequestDTO;
import org.gowtham.job_management_admin_interface_backend.Model.JobPost;
import org.gowtham.job_management_admin_interface_backend.Service.JobPostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class JobPostController {

    @Autowired
    private JobPostServiceImpl jobPostService;

    @PostMapping("/api/jobs/admin/create")
    public ResponseEntity<?> createJobPost(@RequestBody JobPostRequestDTO jobPostRequestDTO) {

        JobPost newJobPost = new JobPost();
        newJobPost.setJobTitle(jobPostRequestDTO.getJobTitle());
        newJobPost.setJobDescription(jobPostRequestDTO.getJobDescription());
        newJobPost.setCompanyName(jobPostRequestDTO.getCompanyName());
        newJobPost.setLocation(jobPostRequestDTO.getLocation());
        newJobPost.setJobType(jobPostRequestDTO.getJobType());
        newJobPost.setApplicationDeadline(jobPostRequestDTO.getApplicationDeadLine());
        newJobPost.setMaxSalary(jobPostRequestDTO.getMaxSalary());
        newJobPost.setMinSalary(jobPostRequestDTO.getMinSalary());

        try {
            JobPost createdPost = jobPostService.createJobPost(newJobPost);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);

        } catch (Exception e) {
            ErrorResponseDTO error = new ErrorResponseDTO();
            error.setMessage("Job Post Creation Failed: " + e.getMessage());
            error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @GetMapping("/api/jobs/admin/getAllPosts")
    public ResponseEntity<?> getAllJobPosts() {

        List<JobPost> jobPosts = jobPostService.getAllJobPosts();

        if (jobPosts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Job Posts Found");
        }else  {
            return ResponseEntity.status(OK).body(jobPosts);
        }

    }
    @PostMapping("/api/jobs/admin/getPostsByFilters")
    public ResponseEntity<?> searchJobs(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String jobTitle,
            @RequestParam(required = false) String jobType,
            @RequestParam(required = false) Integer minSalary,
            @RequestParam(required = false) Integer maxSalary
    ) {
        System.out.println(jobTitle);
        List<JobPost> jobPosts=jobPostService.searchJobs(location, jobTitle, jobType, minSalary, maxSalary);
        if(jobPosts.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("No Job Posts Found");
        }

        return ResponseEntity.status(OK).body(jobPosts );
    }

}

