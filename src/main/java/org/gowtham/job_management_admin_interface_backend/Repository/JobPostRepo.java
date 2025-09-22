package org.gowtham.job_management_admin_interface_backend.Repository;

import org.gowtham.job_management_admin_interface_backend.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


    @Repository
    public interface JobPostRepo extends JpaRepository<JobPost, Long> {

        @Query("SELECT j FROM JobPost j " +
                "WHERE LOWER(j.location) LIKE LOWER(CONCAT('%', COALESCE(:location, ''), '%')) " +
                "AND LOWER(j.jobTitle) LIKE LOWER(CONCAT('%', COALESCE(:jobTitle, ''), '%')) " +
                "AND LOWER(j.jobType) LIKE LOWER(CONCAT('%', COALESCE(:jobType, ''), '%')) " +
                "AND (:minSalary IS NULL OR j.minSalary >= :minSalary) " +
                "AND (:maxSalary IS NULL OR j.maxSalary <= :maxSalary)")
        List<JobPost> searchJobs(@Param("location") String location,
                                 @Param("jobTitle") String jobTitle,
                                 @Param("jobType") String jobType,
                                 @Param("minSalary") Integer minSalary,
                                 @Param("maxSalary") Integer maxSalary);


    }


