package com.EjercicioAyudantia.ISoft.task;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.webmvc.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TaskController.class)
@Import(TaskRepository.class)
class TaskControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void creaTareaYRetorna201() throws Exception {
		mockMvc.perform(post("/tasks")
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
								{
								  "titulo": "Revisar documentación de la API",
								  "prioridad": "ALTA",
								  "fechaLimite": "2025-06-30"
								}
								"""))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.titulo").value("Revisar documentación de la API"))
				.andExpect(jsonPath("$.prioridad").value("ALTA"))
				.andExpect(jsonPath("$.fechaLimite").value("2025-06-30"))
				.andExpect(jsonPath("$.completada").value(false));
	}

}
