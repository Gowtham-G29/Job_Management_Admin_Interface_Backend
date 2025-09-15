package org.gowtham.job_management_admin_interface_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobFilterRequestDTO {

    private String jobTitle;
    private String location;
    private String jobType;
    private Integer minSalary;
    private Integer maxSalary;

}
