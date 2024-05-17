package study.mapstruct.mapstruct.service;

import org.springframework.stereotype.Service;
import study.mapstruct.mapstruct.entity.Contract;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractService {

    public List<Contract> contracts(){
        List<Contract> contracts = new ArrayList<>();

        contracts.add(new Contract(1, "An", "Hoang", "1", "11"));
        contracts.add(new Contract(2, "Khánh", "Giang", "2", "12"));
        contracts.add(new Contract(3, "Phát", "Hoang", "3", "13"));
        contracts.add(new Contract(4, "Dũng", "Tấn", "4", "14"));

        return contracts;
    }
}
