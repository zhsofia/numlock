package numberlockapp.numberlock.service.implementation;

import numberlockapp.numberlock.entity.NumComb;
import numberlockapp.numberlock.entity.Solution;
import numberlockapp.numberlock.service.NumberLockService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BasicNumberLockService implements NumberLockService {

    @Override
    public ArrayList<Solution> basicSolution(NumComb numComb) {
        return null;
    }
}
