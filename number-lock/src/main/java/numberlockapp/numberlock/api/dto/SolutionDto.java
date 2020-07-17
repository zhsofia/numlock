package numberlockapp.numberlock.api.dto;

import lombok.*;

import java.util.ArrayList;


@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SolutionDto {

    private ArrayList<Long> combination;

    private Long solution;

    private Long rotations;

}
