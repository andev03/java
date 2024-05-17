package study.mapstruct.mapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import study.mapstruct.mapstruct.entity.Contract;
import study.mapstruct.mapstruct.model.ContractModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractMapper {


    Contract toEntity(ContractModel contractModel);

    @Mapping(source = "firstName", target = "firstName", qualifiedByName = "checkCustomMapping")
    ContractModel toModel(Contract contract);

    List<ContractModel> toModelList(List<Contract> contracts);

    @Named("checkCustomMapping")
    default String checkContract(String firstName){
        if (firstName.equals("An")){
            return "Hello";
        }else {
            return "Hoang";
        }
    }
}
