package numberlockapp.numberlock.service.calculator;

import lombok.NoArgsConstructor;
import numberlockapp.numberlock.entity.NumComb;
import numberlockapp.numberlock.entity.Solution;
import org.springframework.stereotype.Component;

import javax.lang.model.util.Types;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Component
@NoArgsConstructor
public class Calculator {

    private static final Long BASE = 10L;

    private Long calculateRotationsXY(Long x, Long y) {
        if (Math.abs(x - y) <= BASE / 2) {
            return Math.abs(x - y);
        } else {
            return BASE - Math.abs(x - y);
        }
    }

    public ArrayList<Solution> calculateSolutions(NumComb numComb) {
        ArrayList<Solution> solutions = new ArrayList<>();
        Long minRotations = Long.MAX_VALUE;
        for (int i = 0; i < BASE; i++) {
            Long currRotations = 0L;
            for (int j = 0; j < numComb.getCombination().size(); j++) {
                Long rotations = calculateRotationsXY(numComb.getCombination().get(j), (long) i);
                currRotations += rotations;
            }
            if (currRotations == minRotations) {
                Solution solution = Solution.builder()
                        .combination(numComb.getCombination())
                        .rotations(currRotations)
                        .solution((long) i).build();
                solutions.add(solution);
            } else if (currRotations < minRotations) {
                Solution solution = Solution.builder()
                        .combination(numComb.getCombination())
                        .rotations(currRotations)
                        .solution((long) i).build();
                solutions.clear();
                solutions.add(solution);
                minRotations=currRotations;
            }
        }
        return solutions;
    }
}
