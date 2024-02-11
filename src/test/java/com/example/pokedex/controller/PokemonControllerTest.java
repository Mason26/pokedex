package com.example.pokedex.controller;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;
import com.example.pokedex.domain.PokemonDTO;
import com.example.pokedex.service.PokemonService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.springframework.restdocs.RestDocumentationExtension;

// @TestInstance(TestInstance.Lifecycle.PER_CLASS)
// @WebMvcTest(PokemonController.class)
// @ExtendWith(SpringExtension.class)
@SpringBootTest
public class PokemonControllerTest {


    @Autowired
	private PokemonController controller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

    // @Autowired
    // private WebApplicationContext context;

    // @Autowired
    // private MockMvc mockMvc;

    // @Autowired
    // private ApplicationContext context;

    //  @Mock
    // private PokemonService pokemonService;

    // @Test
    // public void testGetPokemon() throws Exception {
    //     // Mock Pokemon data
    //     PokemonDTO gengar = new PokemonDTO("gengar");

        // Stub the service method to return the mock Pokemon data
        // when(pokemonService.getPokemon("gengar")).thenReturn(gengar);

        // Perform the GET request to retrieve Pokemon "Gengar"
        // mockMvc.perform(MockMvcRequestBuilders.get("/api/pokedex/pokemon")
        //         .contentType(MediaType.APPLICATION_JSON))
        //         .andExpect(MockMvcResultMatchers.status().isOk())
        //         .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("gengar"));
    // }


    // @Test
    // public void test_canCallControllerMethod_controllerMethodCalled() throws Exception {
    //     String expectedJson = "{\"message\":\"Hello World\"}";
    //     System.out.println(context);

    //     mockMvc.perform(get("/api/pokedex/pokemon"))
    //             .andExpect(status().isOk())
    //             .andExpect(content().json(expectedJson));
    // }

}
