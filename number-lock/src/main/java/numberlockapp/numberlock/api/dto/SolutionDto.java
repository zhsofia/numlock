package numberlockapp.numberlock.api.dto;

import lombok.*;


@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SolutionDto {

    private String combination;

    private Long solution;

    private Long rotations;

}
