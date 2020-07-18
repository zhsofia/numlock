package numberlockapp.numberlock.api;

import numberlockapp.numberlock.NumberLockApplication;
import numberlockapp.numberlock.api.dto.SolutionDto;
import numberlockapp.numberlock.api.mapper.SolutionMapper;
import numberlockapp.numberlock.entity.NumComb;
import numberlockapp.numberlock.service.NumberLockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping(value = "/api/v1/numlock")
public class NumberLockEndpoint {

    private SolutionMapper solutionMapper;
    private NumberLockService numberLockService;
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    public NumberLockEndpoint(SolutionMapper solutionMapper, NumberLockService numberLockService) {
        this.solutionMapper = solutionMapper;
        this.numberLockService = numberLockService;
    }

    @GetMapping(path = "/basic/{combination}")
    public ArrayList<SolutionDto> basicSolution(@PathVariable @NotNull @Pattern(regexp = "[0-" + (NumberLockApplication.BASE - 1) + "]" +
            "([-][0-" + (NumberLockApplication.BASE - 1) + "]){" + (NumberLockApplication.NUM - 1) + "}",
            message = "The combination should contain " + NumberLockApplication.NUM + "numbers from 0 to " +
                    NumberLockApplication.BASE + " each divided by -.") String combination) {
        LOGGER.info("GET /api/v1/numlock/basic/{}", combination);
        ArrayList<Long> numbersList = Arrays.stream(combination.split("-")).mapToLong(Long::parseLong)
                .boxed().collect(Collectors.toCollection(ArrayList::new));

        return numberLockService.basicSolution(NumComb.builder().combination(numbersList).build()).stream()
                .map(x -> solutionMapper.solutionToSolutionDto(x)).collect(Collectors.toCollection(ArrayList::new));
    }
}
