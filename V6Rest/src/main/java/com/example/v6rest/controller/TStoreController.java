package com.example.v6rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.v6rest.model.TStore;
import com.example.v6rest.service.TStoreService;

@RestController
@RequestMapping("/stores")
public class TStoreController {

	@Autowired
	private TStoreService tStoreService;
	
	@GetMapping
	public List<TStore> findAll() {
		return tStoreService.findAll();
	}
	
	@GetMapping("/{storeId}")
	public Optional<TStore> findById(@PathVariable Integer storeId) {
		return this.tStoreService.findById(storeId);
	}
	
	@PostMapping
	public TStore insertStore(@RequestBody TStore tStore) {
		return this.tStoreService.insertStore(tStore);
	}
	
	@DeleteMapping("/{storeId}")
	public void deleteStore(@PathVariable Integer storeId) {
		this.tStoreService.deleteStore(storeId);
	}
	
	@PutMapping("/{storeId}")
	public TStore updateStore(@RequestBody TStore tStore, @PathVariable Integer storeId) {
		return tStoreService.updateStore(tStore);
	}
	
}
