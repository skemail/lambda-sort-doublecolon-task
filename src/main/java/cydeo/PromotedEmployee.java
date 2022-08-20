package cydeo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PromotedEmployee {

    private Role role;
    private Integer salary;
}
