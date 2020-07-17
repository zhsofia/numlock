package numberlockapp.numberlock.service.implementation;

import numberlockapp.numberlock.entity.NumComb;
import numberlockapp.numberlock.entity.Solution;
import numberlockapp.numberlock.service.NumberLockService;
import numberlockapp.numberlock.service.calculator.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BasicNumberLockService implements NumberLockService {

    private Calculator calculator;

    @Autowired
    public BasicNumberLockService(Calculator calculator){
        this.calculator=calculator;
    }

    @Override
    public ArrayList<Solution> basicSolution(NumComb numComb) {
        return calculator.calculateSolutions(numComb);
    }
}
