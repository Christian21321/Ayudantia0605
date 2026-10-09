package com.EjercicioAyudantia.ISoft.task;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	private final TaskRepository repository;

	public TaskController(TaskRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Task create(@RequestBody Task tarea) {
		return repository.save(tarea);
	}

}

