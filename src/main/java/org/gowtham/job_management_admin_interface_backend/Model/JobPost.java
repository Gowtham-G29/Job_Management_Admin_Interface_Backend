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
    Long postId;

    String JobTitle;
    String CompanyName;
    String Location;

    int MinSalary;
    int MaxSalary;

    LocalDate ApplicationDeadLine;

    String JobDescription;

    @CreationTimestamp
    LocalDate CreatedDate;


}
