package numberlockapp.numberlock.entity;

import lombok.*;
import numberlockapp.numberlock.NumberLockApplication;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;


@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NumComb {

    @NotNull(message = "The combination cannot be empty.")
    @Size(min = NumberLockApplication.NUM, max = NumberLockApplication.NUM,
            message = "The combination should be "+ NumberLockApplication.NUM +" long.")
    private ArrayList<Long> combination;

}
