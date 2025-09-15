package org.gowtham.job_management_admin_interface_backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {

   private  String message;
   private HttpStatus statusCode;
}
