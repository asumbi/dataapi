package com.joshua.dataapi.controller;

import com.joshua.dataapi.dao.ConsentRepo;
import com.joshua.dataapi.dao.CustomerDataRepo;
import com.joshua.dataapi.model.Consent;
import com.joshua.dataapi.model.CustomerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path="/consents/{dialogid}", consumes= {"application/json"})
    public Consent addCustomerData(@RequestBody Consent consent, @PathVariable int dialogid){
        System.out.println("Dialogid: " + dialogid);
        crepo.save(consent);
        Consent cons = crepo.findById(consent.getId()).orElse(null);
        CustomerData da = cdata.findById(dialogid).orElse(null);

        if ( da != null ){
            cons.setCustomerdata(da);
            crepo.save(cons);
        }
        else{
            System.out.println("Customer data not found !");
            crepo.delete(cons);
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
