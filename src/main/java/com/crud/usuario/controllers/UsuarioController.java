package com.crud.usuario.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.usuario.models.UsuarioModel;
import com.crud.usuario.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	
	@Autowired
	UsuarioService usuarioServicice;
	
	@GetMapping
	public ArrayList<UsuarioModel> obtenerUsuarios(){
		return usuarioServicice.obtenerUsuarios();
		
		
	}
	
	@PostMapping	
	public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
		return this.usuarioServicice.guardarUsuario(usuario);
	}
	
	
	@GetMapping(path = "/{id}")
	public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
		return this.usuarioServicice.obtenerPorId(id);
	}
	
	@GetMapping(path = "/query")
	public ArrayList<UsuarioModel> obtenerPorPrioridad(@RequestParam("prioridad") Integer prioridad){
		
		return this.usuarioServicice.obtenerPorPrioridad(prioridad);
		
		
	}
	
	
	@DeleteMapping(path ="/{id}")
	public String eliminaPorId(@PathVariable("id")Long id) {
		boolean ok = this.usuarioServicice.eliminaUsuario(id);
		
		if(ok) {
			return "Se eliminino el usuario con id" + id;
		}else {
			return "No pudo eliminar el usuario con id"+id;
		}
		
		
		
	}
	

}
