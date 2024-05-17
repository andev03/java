package study.mapstruct.mapstruct.model;

import lombok.Data;

@Data
public class OrderModel {
    private Long id;

    private String orderAmount;

    private String description;

    private String orderDate;

    private String orderStatus;

    private int quantity;

}
