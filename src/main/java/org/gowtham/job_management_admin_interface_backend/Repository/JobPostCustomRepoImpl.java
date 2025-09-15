package org.gowtham.job_management_admin_interface_backend.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.gowtham.job_management_admin_interface_backend.DTO.JobFilterRequestDTO;
import org.gowtham.job_management_admin_interface_backend.Model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobPostCustomRepoImpl implements JobPostCustomRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<JobPost> findByAnyFilters(JobFilterRequestDTO filterRequest) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<JobPost> cq = cb.createQuery(JobPost.class);
        Root<JobPost> job = cq.from(JobPost.class);

        List<Predicate> predicates = new ArrayList<>();

        if (filterRequest.getJobTitle() != null) {
            predicates.add(cb.equal(job.get("jobTitle"), filterRequest.getJobTitle()));
        }

        if (filterRequest.getLocation() != null) {
            predicates.add(cb.equal(job.get("location"), filterRequest.getLocation()));
        }

        if (filterRequest.getJobType() != null) {
            predicates.add(cb.equal(job.get("jobType"), filterRequest.getJobType()));
        }

        if (filterRequest.getMinSalary() != null) {
            predicates.add(cb.equal(job.get("minSalary"), filterRequest.getMinSalary()));
        }

        if (filterRequest.getMaxSalary() != null) {
            predicates.add(cb.equal(job.get("maxSalary"), filterRequest.getMaxSalary()));
        }

        if (predicates.isEmpty()) {
            // No filters provided → return empty list
            return new ArrayList<>();
        }

        cq.where(cb.and(predicates.toArray(new Predicate[0])));

        return em.createQuery(cq).getResultList();
    }


}

