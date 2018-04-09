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
	
	public TStore insertStore(TStore tStore) {
		if (!this.tStoreRepository.existsById(tStore.getId()))
			return this.tStoreRepository.save(tStore);
		else
			return null;
	}

	public void deleteStore(Integer storeId) {
		Optional<TStore> opt = this.tStoreRepository.findById(storeId);
		if (opt.isPresent())
			this.tStoreRepository.delete(opt.get());		
	}

	public TStore updateStore(TStore tStore) {
		Optional<TStore> opt = this.tStoreRepository.findById(tStore.getId());
		if (opt.isPresent())
			this.tStoreRepository.save(tStore);
		return opt.get();
	}
}
