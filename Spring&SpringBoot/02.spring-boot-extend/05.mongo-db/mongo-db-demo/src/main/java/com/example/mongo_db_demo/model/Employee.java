package com.example.mongo_db_demo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "employee")
@Data
@Builder
public class Employee {

    private String id;

    private String empName;

    private String location;

    private BigDecimal salary;
}
