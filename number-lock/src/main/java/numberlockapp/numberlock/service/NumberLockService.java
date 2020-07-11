package numberlockapp.numberlock.service;


import numberlockapp.numberlock.entity.NumComb;
import numberlockapp.numberlock.entity.Solution;

import java.util.ArrayList;

public interface NumberLockService {

    ArrayList<Solution> basicSolution(NumComb numComb);

}
