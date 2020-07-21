package numberlockapp.numberlock.unit;

import numberlockapp.numberlock.api.dto.SolutionDto;
import numberlockapp.numberlock.api.mapper.SolutionMapper;
import numberlockapp.numberlock.entity.Solution;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SolutionMapperTests {

    @Autowired
    SolutionMapper solutionMapper;

    @Test
    public void solutionMapperTest(){
        SolutionDto solutionDto = solutionMapper.solutionToSolutionDto(
                Solution.builder().rotations(4L).solution(1L).combination(
                        new ArrayList<Long>(Arrays.asList(1L, 1L, 1L, 5L))).build());
        assertEquals(solutionDto.getSolution(),"1-1-1-1");
        assertEquals(solutionDto.getRotations(),4L);
        assertEquals(solutionDto.getCombination(),"1-1-1-5");
    }

    @Test
    public void solutionMapperTest2(){
        SolutionDto solutionDto = solutionMapper.solutionToSolutionDto(
                Solution.builder().rotations(0L).solution(0L).combination(
                        new ArrayList<Long>(Arrays.asList(0L, 0L, 0L, 0L))).build());
        assertEquals(solutionDto.getSolution(),"0-0-0-0");
        assertEquals(solutionDto.getRotations(),0L);
        assertEquals(solutionDto.getCombination(),"0-0-0-0");
    }
}
