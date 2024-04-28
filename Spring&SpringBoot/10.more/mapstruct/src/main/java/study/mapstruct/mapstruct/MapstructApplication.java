package study.mapstruct.mapstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import study.mapstruct.mapstruct.mapper.ContractMapper;
import study.mapstruct.mapstruct.model.ContractModel;
import study.mapstruct.mapstruct.service.ContractService;

@SpringBootApplication
public class MapstructApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapstructApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ContractService contractService, ContractMapper contractMapper) {
        return args -> {
            for (ContractModel contractModel : contractMapper.toModelList(contractService.contracts())) {
                System.out.println(contractModel);
            }
        };
    }

}
