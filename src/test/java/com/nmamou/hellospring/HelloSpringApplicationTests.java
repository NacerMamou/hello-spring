package com.nmamou.hellospring;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// this is a custom import using status keywrd inorder to be able to use status and others
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.nmamou.hellospring.controller.GradeController;

@SpringBootTest
// Add mockmvc for integration testing
@AutoConfigureMockMvc
class HelloSpringApplicationTests {

	// @Autowired
	// private GradeController controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		// Verfify that the controller is not nul
		// assertNotNull(controller);
		assertNotNull(mockMvc);
	}

	@Test
	public void getFormTest() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.get("/?123");
		mockMvc.perform(request)
			.andExpect(status().is2xxSuccessful())
			.andExpect(view().name("form"))
			.andExpect(model().attributeExists("grade"));
	}

	@Test 
	public void getGradesTest() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.get("/grades");
		mockMvc.perform(request)
			.andExpect(status().is2xxSuccessful())
			.andExpect(view().name("grades"))
			.andExpect(model().attributeExists("grades"));
	}

	@Test
	public void submitGradeTest() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.post("/handleSubmit")
			.param("name", "Nacer")
			.param("subject", "Math")
			.param("score", "12");
		mockMvc.perform(request)
			.andExpect(status().is3xxRedirection())
			.andExpect(redirectedUrl("/grades"));
			// .andExpect(model().attributeExists("grades"));
	}
}
