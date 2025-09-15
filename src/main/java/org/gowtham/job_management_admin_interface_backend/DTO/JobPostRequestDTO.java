package org.gowtham.job_management_admin_interface_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostRequestDTO {

    private String jobTitle;
    private String companyName;
    private String location;
    private String jobType;

    private int minSalary;
    private int maxSalary;

    private LocalDate applicationDeadLine;

    private String jobDescription;
}

