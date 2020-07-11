package numberlockapp.numberlock.api;

import numberlockapp.numberlock.api.dto.SolutionDto;
import numberlockapp.numberlock.api.mapper.SolutionMapper;
import numberlockapp.numberlock.entity.NumComb;
import numberlockapp.numberlock.service.NumberLockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Validated
@RestController
public class NumberLockEndpoint {

    private SolutionMapper solutionMapper;
    private NumberLockService numberLockService;

    @Autowired
    public NumberLockEndpoint(SolutionMapper solutionMapper, NumberLockService numberLockService) {
        this.solutionMapper = solutionMapper;
        this.numberLockService = numberLockService;
    }

    @GetMapping(path = "/basic/{combination}")
    public ArrayList<SolutionDto> basicSolution(@PathVariable @NotNull @Pattern(regexp = "[0-9]-[0-9]-[0-9]-[0-9]",
            message = "The combination should have the following form: [0-9]-[0-9]-[0-9]-[0-9]")
                                                        String combination) {


        ArrayList<Long> numbersList = Arrays.stream(combination.split("-")).mapToLong(Long::parseLong)
                .boxed().collect(Collectors.toCollection(ArrayList::new));

        return numberLockService.basicSolution(NumComb.builder().combination(numbersList).build()).stream()
                .map(x -> solutionMapper.solutionToSolutionDto(x)).collect(Collectors.toCollection(ArrayList::new));
    }
}
