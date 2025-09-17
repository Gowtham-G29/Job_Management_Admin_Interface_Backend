package org.gowtham.job_management_admin_interface_backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_post") // must match the table name exactly
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(name = "job_title")
    private String jobTitle;

   private String companyName;
    @Column(name = "location")
    private String location;
   private String jobType;

    @Column(name = "min_salary")
    private Integer minSalary;

    @Column(name = "max_salary")
    private Integer maxSalary;


    private LocalDate applicationDeadLine;

   private String JobDescription;

    @CreationTimestamp
   private LocalDateTime CreatedDate;


}
