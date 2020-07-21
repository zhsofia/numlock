package numberlockapp.numberlock.service.implementation;

import numberlockapp.numberlock.entity.NumComb;
import numberlockapp.numberlock.entity.Solution;
import numberlockapp.numberlock.service.NumberLockService;
import numberlockapp.numberlock.service.calculator.Calculator;
import numberlockapp.numberlock.service.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BasicNumberLockService implements NumberLockService {

    private Calculator calculator;
    private Validator validator;

    @Autowired
    public BasicNumberLockService(Calculator calculator, Validator validator){
        this.calculator=calculator;
        this.validator=validator;
    }

    @Override
    public ArrayList<Solution> basicSolution(NumComb numComb) {
        validator.validateNumComb(numComb);
        return calculator.calculateSolutions(numComb);
    }
}
