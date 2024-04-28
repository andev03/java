package study.mapstruct.mapstruct.entity;

import lombok.Data;

@Data
public class Order {
    private Long id;

    private String amount;

    private String description;

    private String date;

    private String status;

    private int quantity;

}
