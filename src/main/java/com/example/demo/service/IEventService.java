package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Event;

public interface IEventService {

	public boolean insert(Event event);

	public boolean update(Event event);


	public boolean delete(String id);

	public List<Event> findAll();


	public Optional<Event> findById(String id);

	public List<Event> findByName(String name);
}
