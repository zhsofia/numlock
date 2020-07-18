package numberlockapp.numberlock.api.mapper;

import numberlockapp.numberlock.NumberLockApplication;
import numberlockapp.numberlock.api.dto.SolutionDto;
import numberlockapp.numberlock.entity.Solution;
import org.springframework.stereotype.Component;

@Component
public class SolutionMapper {

    public SolutionDto solutionToSolutionDto(Solution solution) {
        String sol = "" + solution.getSolution();
        String comb = "" + solution.getCombination().get(0);
        for (int i = 1; i < NumberLockApplication.NUM; i++) {
            sol = sol + "-" + solution.getSolution();
            comb=comb + "-" + solution.getCombination().get(i);
        }
        return SolutionDto.builder()
                .combination(comb)
                .rotations(solution.getRotations())
                .solution(sol)
                .build();
    }
}
