package com.example.springthymeleafupload.smart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartService {
    @Autowired
    private SmartRepository smartRepository;

    public List<Smart> findAll(){
        return smartRepository.findAll();
    }
    public Smart findById(Long id){
        return smartRepository.findById(id).get();
    }

    public void save(Smart smart){
        smartRepository.save(smart);
    }

    public void deleteById(Long id){
        smartRepository.deleteById(id);
    }
}
