package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Event;

public interface IEventService {

	public boolean insert(Event event);

	public boolean update(Event event);

	//Probablemente haya que cambiar el tipo de ID
	public boolean delete(Integer id);

	public List<Event> findAll();

	//Probablemente haya que cambiar el tipo de ID
	public Optional<Event> findById(Integer id);

	public List<Event> findByName(String name);
}
