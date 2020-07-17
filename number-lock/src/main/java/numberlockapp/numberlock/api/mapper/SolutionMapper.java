package numberlockapp.numberlock.api.mapper;

import numberlockapp.numberlock.api.dto.SolutionDto;
import numberlockapp.numberlock.entity.Solution;
import org.springframework.stereotype.Component;

@Component
public class SolutionMapper {

    public SolutionDto solutionToSolutionDto(Solution solution){
        return SolutionDto.builder()
                .combination(solution.getCombination())
                .rotations(solution.getRotations())
                .solution(solution.getSolution())
                .build();
    }
}
