package study.mapstruct.mapstruct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.mapstruct.mapstruct.mapper.ContractMapper;
import study.mapstruct.mapstruct.model.ContractModel;
import study.mapstruct.mapstruct.service.ContractService;

import java.util.List;

@RestController
public class ContractController {

    private final ContractService contractService;

    ContractMapper contractMapper;

    @Autowired
    public ContractController(ContractService contractService, ContractMapper contractMapper) {
        this.contractService = contractService;
        this.contractMapper = contractMapper;
    }


    @GetMapping("/contract")
    public List<ContractModel> getAllContract() {
        return contractMapper.toModelList(contractService.contracts());
    }
}
