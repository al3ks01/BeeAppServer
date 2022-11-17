package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Event;
import com.example.demo.service.IEventService;

@RestController
@RequestMapping("beeapp/event")
@CrossOrigin
public class EventControllerRest {

	@Autowired
	IEventService eventService;

	// crud + crear evento.
	@GetMapping("/consult")
	public ResponseEntity<List<Event>> getEvents() {

		return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
	}

	@PostMapping("/insert")
	public ResponseEntity<Event> insertUser(@Valid @RequestBody Event event) {

		HttpStatus status = HttpStatus.CREATED;

		if (!eventService.insert(event)) {
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<>(event, status);
	}

	@GetMapping("/consult/{id}")
	public ResponseEntity<Event> getEvent(@PathVariable("id") String id) {

		ResponseEntity<Event> response;
		Optional<Event> event;

		event = eventService.findById(id);

		if (event.isPresent()) {
			response = new ResponseEntity<>(event.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@PutMapping("/update")
	public ResponseEntity<Event> updateEvent(@Valid @RequestBody Event event) {

		HttpStatus status = HttpStatus.ACCEPTED;

		if (!eventService.update(event))
			status = HttpStatus.BAD_REQUEST;

		return new ResponseEntity<>(event, status);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEvent(@PathVariable String id) {
		HttpStatus status = HttpStatus.OK;

		if (!eventService.delete(id))
			status = HttpStatus.NOT_FOUND;

		return new ResponseEntity<>(id.toString(), status);
	}

	// puede haber más de un evento con el mismo nombre
	@GetMapping("/consultbyname")
	public ResponseEntity<List<Event>> getEventByName(@RequestParam String name) {
		ResponseEntity<List<Event>> response;
		List<Event> events;

		System.out.println("recibido " + name);

		events = eventService.findByName(name);

		if (!events.isEmpty()) {
			response = new ResponseEntity<>(events, HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return response;
	}
}
