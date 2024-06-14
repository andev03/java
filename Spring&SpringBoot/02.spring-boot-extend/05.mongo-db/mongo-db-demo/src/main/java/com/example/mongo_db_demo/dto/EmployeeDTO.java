package com.example.mongo_db_demo.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Data
@Builder
public class EmployeeDTO {
    @Id
    private String id;

    @Field(name = "employee_name")
    private String empName;

    private String location;

    private BigDecimal salary;
}
