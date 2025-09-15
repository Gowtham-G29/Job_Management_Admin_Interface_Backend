package org.gowtham.job_management_admin_interface_backend.Controller;

import org.gowtham.job_management_admin_interface_backend.DTO.ErrorResponseDTO;
import org.gowtham.job_management_admin_interface_backend.DTO.JobPostRequestDTO;
import org.gowtham.job_management_admin_interface_backend.Model.JobPost;
import org.gowtham.job_management_admin_interface_backend.Service.JobPostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobPostController {

    @Autowired
    private JobPostServiceImpl jobPostService;

    @PostMapping("/api/jobs/admin/create")
    public ResponseEntity<?> createJobPost(@RequestBody JobPostRequestDTO jobPostRequestDTO) {

        // Map DTO → Entity
        JobPost newJobPost = new JobPost();
        newJobPost.setJobTitle(jobPostRequestDTO.getJobTitle());
        newJobPost.setJobDescription(jobPostRequestDTO.getJobDescription());
        newJobPost.setCompanyName(jobPostRequestDTO.getCompanyName());
        newJobPost.setLocation(jobPostRequestDTO.getLocation());
        newJobPost.setApplicationDeadLine(jobPostRequestDTO.getApplicationDeadLine());
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

}
