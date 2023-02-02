package cydeo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromotedEmployee {

    private Role role;
    private Integer salary;
    private Employee employee;
}
