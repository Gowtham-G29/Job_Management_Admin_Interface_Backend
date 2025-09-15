package org.gowtham.job_management_admin_interface_backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

   private String JobTitle;
   private String CompanyName;
   private String Location;

   private int minSalary;
   private int maxSalary;

   private LocalDate applicationDeadLine;

   private String JobDescription;

    @CreationTimestamp
   private LocalDate CreatedDate;


}
