package com.example.v6rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.v6rest.model.TStore;
import com.example.v6rest.repository.TStoreRepository;

@Service
public class TStoreService {

	@Autowired
	TStoreRepository tStoreRepository; 
	
	public List<TStore> findAll() {
		return this.tStoreRepository.findAll();
	}
	
	public Optional<TStore> findById(Integer id) {
		return this.tStoreRepository.findById(id);
	}
	

}
