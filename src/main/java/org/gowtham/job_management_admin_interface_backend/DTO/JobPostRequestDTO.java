package org.gowtham.job_management_admin_interface_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostRequestDTO {

    String JobTitle;
    String CompanyName;
    String Location;

    int MinSalary;
    int MaxSalary;

    LocalDate ApplicationDeadLine;

    String JobDescription;
}
