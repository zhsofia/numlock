package numberlockapp.numberlock.entity;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Solution {

    private ArrayList<Long> combination;

    private Long solution;

    private Long rotations;


}
