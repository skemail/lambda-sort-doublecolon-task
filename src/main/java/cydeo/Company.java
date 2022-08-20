package cydeo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Company {

    private Integer id;
    private String companyName;
    private Address address;
}
