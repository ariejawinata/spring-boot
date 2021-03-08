package id.co.mandiri.induction.springboot.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {

    private int employeeId;
    private String firstName;

}

