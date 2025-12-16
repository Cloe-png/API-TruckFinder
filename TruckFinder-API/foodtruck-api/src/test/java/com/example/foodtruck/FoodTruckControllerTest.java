package com.example.foodtruck;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FoodTruckControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    void shouldReturnFoodTrucks() throws Exception {
        mvc.perform(get("/api/foodtrucks"))
                .andExpect(status().isOk());
    }

    /**
     * Test volontairement en échec pour voir comment la CI réagit.
     */
    @Test
    void failingTestForCiDemo() {
        // On s'attend "exprès" à un résultat faux :
        // 1 == 2 -> ça va échouer
        assertEquals(1, 1, "Ce test est volontairement en échec pour la démo CI");
    }
}
