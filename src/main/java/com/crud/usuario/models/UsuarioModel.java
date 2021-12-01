package com.crud.usuario.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity//Etiqueta que define a una clase como entidad
@Table(name="usuario")//Etiqueta para definir el nombre de la tabla cuando es distinto al nombre de nuestra clase
@Data//Esta es una etiqueta de lombok que genera automaticamente los getters y setters
@AllArgsConstructor//Etiqueta Lombock que crea un contructor con todos sus argumentos
@NoArgsConstructor//Etiqueta Lombock que crea un constructor vacío
@Builder//Etiqueta Lombock  que permite hacer nuevas instancias de nuestra entidad
public class UsuarioModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	private String nombre;
	private String email;
	private Integer prioridad;

}
