package numberlockapp.numberlock.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import numberlockapp.numberlock.entity.Solution;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@AutoConfigureMockMvc
@SpringBootTest
public class NumLockIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String BASE_URI = "/api/v1/numlock/basic";

    @Test
    public void TestValidInputCombination() throws Exception {
        String validInputCombination1 = "0-0-0-0";
        String validInputCombination2 = "1-1-9-9";
        String validInputCombination3 = "1-2-3-4";

        MvcResult mvcResult = this.mockMvc.perform(get(BASE_URI + "/" + validInputCombination1)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());

        Solution[] solutions = objectMapper.readValue(response.getContentAsString(), Solution[].class);
        assertEquals(solutions.length, 1);
        ArrayList<Long> toCompare = new ArrayList<>(Arrays.asList(0L, 0L, 0L, 0L));
        assertEquals(solutions[0].getCombination(), toCompare);
        assertEquals(solutions[0].getRotations(), 0L);
        assertEquals(solutions[0].getSolution(), 0L);

        mvcResult = this.mockMvc.perform(get(BASE_URI + "/" + validInputCombination2)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();
        response = mvcResult.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
        ArrayList<Long> toCompare2 = new ArrayList<>(Arrays.asList(1L, 1L, 9L, 9L));
        Solution[] solutions2 = objectMapper.readValue(response.getContentAsString(), Solution[].class);
        assertEquals(solutions2.length, 3);
        for (int i = 0; i < solutions2.length; i++) {
            assertEquals(solutions2[i].getCombination(), toCompare2);
            assertEquals(solutions2[i].getRotations(), 4L);
            assertTrue(solutions2[i].getSolution().equals(0L)  || solutions2[i].getSolution().equals(1L) || solutions2[i].getSolution().equals(9L));
        }

        mvcResult = this.mockMvc.perform(get(BASE_URI + "/" + validInputCombination3)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();
        response = mvcResult.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
        ArrayList<Long> toCompare3 = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 4L));
        Solution[] solutions3 = objectMapper.readValue(response.getContentAsString(), Solution[].class);
        assertEquals(solutions3.length, 2);
        for (int i = 0; i < solutions3.length; i++) {
            assertEquals(solutions3[i].getCombination(), toCompare3);
            assertEquals(solutions3[i].getRotations(), 4L);
            assertTrue(solutions3[i].getSolution().equals(2L)||solutions3[i].getSolution().equals(3L));
        }

    }

    @Test
    public void invalidInputTest_expectStatusBadRequest() throws Exception{
        String invalidInputCombination1 = "0000";
        String invalidInputCombination2 = "11-3-45-788";


        MvcResult mvcResult = this.mockMvc.perform(get(BASE_URI + "/" + invalidInputCombination1)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());

        mvcResult = this.mockMvc.perform(get(BASE_URI + "/" + invalidInputCombination2)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();
        response = mvcResult.getResponse();

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
    }
}
