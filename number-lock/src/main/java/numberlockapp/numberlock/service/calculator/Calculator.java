package numberlockapp.numberlock.service.calculator;

import lombok.NoArgsConstructor;
import numberlockapp.numberlock.NumberLockApplication;
import numberlockapp.numberlock.entity.NumComb;
import numberlockapp.numberlock.entity.Solution;
import numberlockapp.numberlock.service.NumberLockService;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;

@Component
@NoArgsConstructor
public class Calculator {

    private Long calculateRotationsXY(@Min(0) @Max(NumberLockApplication.BASE-1) Long x,
                                      @Min(0) @Max(NumberLockApplication.BASE-1) Long y) {
        if (Math.abs(x - y) <= NumberLockApplication.BASE / 2) {
            return Math.abs(x - y);
        } else {
            return NumberLockApplication.BASE - Math.abs(x - y);
        }
    }

    public ArrayList<Solution> calculateSolutions(NumComb numComb) {
        ArrayList<Solution> solutions = new ArrayList<>();
        Long minRotations = Long.MAX_VALUE;
        for (int i = 0; i < NumberLockApplication.BASE; i++) {
            Long currRotations = 0L;
            for (int j = 0; j < numComb.getCombination().size(); j++) {
                Long rotations = calculateRotationsXY(numComb.getCombination().get(j), (long) i);
                currRotations += rotations;
            }
            if (currRotations.equals(minRotations)) {
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
