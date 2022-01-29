package com.joshua.dataapi.controller;

import com.joshua.dataapi.dao.ConsentRepo;
import com.joshua.dataapi.dao.CustomerDataRepo;
import com.joshua.dataapi.model.Consent;
import com.joshua.dataapi.model.CustomerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsentController {

    @Autowired
    ConsentRepo crepo;

    @Autowired
    CustomerDataRepo cdata;

    @GetMapping("/consents")
    public List<Consent> getConsents(){
        return crepo.findAll();
    }

    @PostMapping(path="/consents", consumes= {"application/json"})
    public Consent addCustomerData(@RequestBody Consent consent){

        crepo.save(consent);

        Consent cons = crepo.findById(consent.getId()).orElse(null);
        System.out.println(cons.getId());

        CustomerData da = cdata.findById(cons.getId()).orElse(null);
        if ( da == null ){
            System.out.println("No customer data found !");

            Consent c1 = crepo.getOne(cons.getId());
            crepo.delete(c1);
            return null;
        }

        if ( cons.getConsent() == false ){
            System.out.println("Consent denied !");
            cdata.delete(da);
            Consent c1 = crepo.getOne(cons.getId());
            crepo.delete(c1);
            return null;
        }
        return consent;
    }

}
