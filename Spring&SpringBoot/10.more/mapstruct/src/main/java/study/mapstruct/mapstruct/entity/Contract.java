package study.mapstruct.mapstruct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contract {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
