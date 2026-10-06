package com.EjercicioAyudantia.ISoft.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

@Repository
public class TaskRepository {

	private final List<Task> tareas = new ArrayList<>();
	private final AtomicLong secuencial = new AtomicLong(0);

	public Task save(Task tarea) {
		tarea.setId(secuencial.incrementAndGet());
		tarea.setCompletada(false);
		tareas.add(tarea);
		return tarea;
	}

	public List<Task> findAll() {
		return new ArrayList<>(tareas);
	}

	public Optional<Task> findById(Long id) {
		return tareas.stream().filter(tarea -> tarea.getId().equals(id)).findFirst();
	}

}
