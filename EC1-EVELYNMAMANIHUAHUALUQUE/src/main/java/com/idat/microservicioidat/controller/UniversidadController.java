package com.idat.microservicioidat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.microservicioidat.model.Universidad;
import com.idat.microservicioidat.service.UniversidadService;

@Controller
@RequestMapping("/universidad/v1")
public class UniversidadController {

	@Autowired
	private UniversidadService service;
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Universidad>> listar() {
		return new ResponseEntity<List<Universidad>>(service.listarUniversidad(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Universidad universidad) {
		service.guardarUniversidad(universidad);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		
		Universidad universidad = service.obtenerUniversidadId(id);
		if(universidad != null) {
			service.eliminarUniversidad(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Universidad universidad) {
		
		Universidad u = service.obtenerUniversidadId(universidad.getIdUniversidad());
		if(u != null) {
			service.actualizarUniversidad(universidad);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Universidad> obtenerId(@PathVariable Integer id) {
		
		Universidad u = service.obtenerUniversidadId(id);
		if(u != null) {
			return new ResponseEntity<Universidad>(service.obtenerUniversidadId(id), HttpStatus.OK);
		}
		return new ResponseEntity<Universidad>(HttpStatus.NOT_FOUND);
	}
}
