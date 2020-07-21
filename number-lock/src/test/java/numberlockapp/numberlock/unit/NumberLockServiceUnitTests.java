package numberlockapp.numberlock.unit;


import numberlockapp.numberlock.entity.NumComb;
import numberlockapp.numberlock.service.NumberLockService;
import numberlockapp.numberlock.service.calculator.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
public class NumberLockServiceUnitTests {

    @Autowired
    NumberLockService numberLockService;

    @MockBean
    Calculator calculator;

    @BeforeEach
    public void beforeEach(){
        Mockito.when(calculator.calculateSolutions(Mockito.any(NumComb.class))).thenReturn(null);
    }

    @Test
    public void validationTest_expectValidationException(){
        Assertions.assertThrows(ValidationException.class,() -> numberLockService.basicSolution(NumComb.builder().combination(new ArrayList<Long>(Arrays.asList(1L, 1L, 1L, 1L, 1L))).build()));
    }

    @Test
    public void validationTest_expectValidationException2(){
        Assertions.assertThrows(ValidationException.class,() -> numberLockService.basicSolution(NumComb.builder().combination(new ArrayList<Long>(Arrays.asList(1L, 1L, 1L, 11L))).build()));
    }

    @Test
    public void validationTest_expectNoValidationException(){
        Assertions.assertDoesNotThrow(() -> numberLockService.basicSolution(NumComb.builder().combination(new ArrayList<Long>(Arrays.asList(1L, 1L, 1L, 1L))).build()));
    }
}
