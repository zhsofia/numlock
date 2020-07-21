package numberlockapp.numberlock.unit;

import numberlockapp.numberlock.entity.NumComb;
import numberlockapp.numberlock.entity.Solution;
import numberlockapp.numberlock.service.calculator.Calculator;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class NumLockCalculatorUnitTests {

    @Autowired
    Calculator calculator;

    @Test
    public void findingSolutions(){
        ArrayList<Solution> solutions =calculator.calculateSolutions(NumComb.builder().combination(new ArrayList<Long>(Arrays.asList(1L, 1L, 1L, 1L))).build());
        assertEquals(solutions.size(),1);
        assertEquals(solutions.get(0).getSolution(),1L);
        assertEquals(solutions.get(0).getRotations(),0L);
    }

    @Test
    public void findingSolutions2(){
        ArrayList<Solution> solutions =calculator.calculateSolutions(NumComb.builder().combination(new ArrayList<Long>(Arrays.asList(0L, 0L, 5L, 5L))).build());
        assertEquals(solutions.size(),10);
        for (int i = 0; i < solutions.size(); i++) {
            assertEquals(solutions.get(i).getRotations(),10L);
        }
    }

    @Test
    public void findingSolutions3(){
        ArrayList<Solution> solutions =calculator.calculateSolutions(NumComb.builder().combination(new ArrayList<Long>(Arrays.asList(1L, 1L, 5L, 5L))).build());
        assertEquals(solutions.size(),5);
        for (int i = 0; i < solutions.size(); i++) {
            assertEquals(solutions.get(i).getRotations(),8L);
            assertTrue(solutions.get(i).getSolution().equals(4L)||solutions.get(i).getSolution().equals(1L)
                    ||solutions.get(i).getSolution().equals(2L) ||solutions.get(i).getSolution().equals(3L)
                    ||solutions.get(i).getSolution().equals(5L));
        }
    }

    @Test
    public void findingSolutions4(){
        ArrayList<Solution> solutions =calculator.calculateSolutions(NumComb.builder().combination(new ArrayList<Long>(Arrays.asList(1L, 1L, 1L, 5L))).build());
        assertEquals(solutions.size(),1);
        assertEquals(solutions.get(0).getSolution(),1L);
        assertEquals(solutions.get(0).getRotations(),4L);
    }

    @Test
    public void findingSolution5(){
        ArrayList<Solution> solutions =calculator.calculateSolutions(NumComb.builder().combination(new ArrayList<Long>(Arrays.asList(1L, 1L, 1L, 7L))).build());
        assertEquals(solutions.size(),1);
        assertEquals(solutions.get(0).getSolution(),1L);
        assertEquals(solutions.get(0).getRotations(),4L);
    }


}
