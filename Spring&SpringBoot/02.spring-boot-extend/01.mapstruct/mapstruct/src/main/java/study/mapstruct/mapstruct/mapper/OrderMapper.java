package study.mapstruct.mapstruct.mapper;

import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import study.mapstruct.mapstruct.entity.Order;
import study.mapstruct.mapstruct.model.OrderModel;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @BeforeMapping
    default void validate(OrderModel orderModel){
        if(orderModel.getQuantity() == 0){
            orderModel.setQuantity(1);
        }
    }
    @Mapping(source = "orderAmount", target = "amount")
    @Mapping(source = "orderDate", target = "date", dateFormat = "yyyy-MMM-dd")
    @Mapping(source = "orderStatus", target = "status", qualifiedByName = "checkOrderStatus")
    Order toEntity(OrderModel orderModel);

    @Mapping(source = "amount", target = "orderAmount")
    @Mapping(source = "date", target = "orderDate", dateFormat = "yyyy-MMM-dd")
    @Mapping(source = "status", target = "orderStatus", qualifiedByName = "checkOrderStatusInString")
    OrderModel toModel(Order order);

    @Named("checkOrderStatus")
    default boolean checOrderStatus(String orderStatus){
        boolean flag;
        if(orderStatus.equals("Delivered")){
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }
}
