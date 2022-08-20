package cydeo;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Employee {

    private Integer id;
    private String fullName;
    private Gender gender;
    private Integer age;
    private Company company;

}
