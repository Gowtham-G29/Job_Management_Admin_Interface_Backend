package org.gowtham.job_management_admin_interface_backend.Repository;

import org.gowtham.job_management_admin_interface_backend.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostRepo extends JpaRepository<JobPost,Long> {

}
