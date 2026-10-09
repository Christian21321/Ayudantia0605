package com.EjercicioAyudantia.ISoft.task;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Task {

	private Long id;
	private String titulo;
	private String prioridad;
	private String fechaLimite;
	private boolean completada;

}
