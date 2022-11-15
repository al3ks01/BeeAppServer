package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;
@Service
public class EventServiceImpl implements IEventService {

	@Autowired
	private EventRepository daoEvent;

	@Override
	public boolean insert(Event event) {
		boolean success = false;

		if (!daoEvent.existsById(event.getId())) {
			success = true;
			daoEvent.save(event);
		}

		return success;
	}

	@Override
	public boolean update(Event event) {
		boolean success = false;

		if (daoEvent.existsById(event.getId())) {
			success = true;
			daoEvent.save(event);
		}

		return success;
	}

	@Override
	public boolean delete(String id) {
		boolean success = false;

		if (daoEvent.existsById(id)) {
			success = true;
			daoEvent.deleteById(id);
		}

		return success;
	}

	@Override
	public List<Event> findAll() {
		return (List<Event>) daoEvent.findAll();
	}

	@Override
	public Optional<Event> findById(String id) {
		return daoEvent.findById(id);
	}

	@Override
	public List<Event> findByName(String name) {
		return daoEvent.findByName(name);
	}

}
