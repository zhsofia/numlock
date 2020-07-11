package numberlockapp.numberlock.entity;

import lombok.*;


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
    @Size(min = 4, max = 4, message = "The combination should be 4 long.")
    private ArrayList<Long> combination;

}
