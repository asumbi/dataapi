package com.joshua.dataapi;

import com.joshua.dataapi.dao.ConsentRepo;
import com.joshua.dataapi.dao.CustomerDataRepo;
import com.joshua.dataapi.model.Consent;
import com.joshua.dataapi.model.CustomerData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DataApiTest {

    @Autowired
    private CustomerDataRepo dataRepo;

    @Autowired
    private ConsentRepo consentRepo;

    CustomerData data;
    Consent consent;

    @BeforeEach // set up before each test
    public void setUp() {
        data = new CustomerData();
        data.setText("I love Java");
        data.setLanguage("EN");

        consent = new Consent();
        consent.setConsent(false);

        //associate customer data with the consent
        consent.setCustomerdata(data);
        data.setConsent(consent);

        dataRepo.save(data);
        consentRepo.save(consent);
    }

    @Test
    public void testAddData() {

        assertThat(data).isNotNull();
        assertThat(consent).isNotNull();

        CustomerData data2 = dataRepo.findById(data.getId()).orElse(null);
        System.out.println(data2.getId());

        Consent cons = consentRepo.findById(consent.getId()).orElse(null);
        System.out.println(cons.getId());
    }

    @Test
    public void testGetDataWithConsent(){
        Consent cons = consentRepo.findById(consent.getId()).orElse(null);
        assertThat(consent.getCustomerdata()).isNotNull();

        CustomerData da = dataRepo.findById(data.getId()).orElse(null);
        assertEquals(3, consent.getCustomerdata().getId());
    }

    @Test
    public void testDeleteDataIfConsentIsFalse(){
        Consent cons = consentRepo.findById(consent.getId()).orElse(null);
        assertThat(consent.getConsent()).isFalse();

        assertEquals(1, dataRepo.findAll().size());
        CustomerData da = dataRepo.findById(cons.getId()).orElse(null);
        dataRepo.delete(da);
        assertEquals(0, dataRepo.findAll().size());
    }

    @Test
    public void testDataIfConsentIsTrue(){
        Consent cons = consentRepo.findById(consent.getId()).orElse(null);
        cons.setConsent(true);
        consentRepo.save(cons);
        assertThat(consent.getConsent()).isTrue();

        assertEquals(1, dataRepo.findAll().size());
    }

}