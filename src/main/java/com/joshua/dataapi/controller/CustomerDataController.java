package com.joshua.dataapi.controller;

import com.joshua.dataapi.dao.CustomerDataRepo;
import com.joshua.dataapi.model.CustomerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerDataController {

    // instantiate customerRepo object in spring container
    @Autowired
    CustomerDataRepo repo;

    @GetMapping("/data")
    public List<CustomerData> getCustomerData(){
        return repo.findAll();
    }

    @GetMapping("/data/{id}")
    public Optional<CustomerData> getData(@PathVariable("id") int id){
        return repo.findById(id);
    }

    @GetMapping("/data/language/{language}")
    public List<CustomerData> getDatal(@PathVariable("language") String language){
        return repo.findByLanguage(language);
    }

    // restFul POST request accepting json object format
    @PostMapping(path="/data", consumes= {"application/json"})
    public CustomerData addCustomerData(@RequestBody CustomerData data){
        repo.save(data);
        return data;
    }

    @PutMapping(path="/data", consumes= {"application/json"})
    public CustomerData addOrUpdateCustomerData(@RequestBody CustomerData data){
        repo.save(data);
        return data;
    }

    @DeleteMapping("/data/{id}")
    public String deleteData(@PathVariable int id){
        CustomerData d1 = repo.getOne(id);
        repo.delete(d1);
        return  "Deleted " + id ;
    }

}
