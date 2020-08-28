package com.vms.registration.controller;

import com.vms.registration.entity.CustomerDetails;
import com.vms.registration.service.RegistrationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class RegistrationControllerTest {

    @InjectMocks
    private RegistrationController registrationController;

    @Mock
    private RegistrationService registrationService;

    @Test
    public void registerCustomerDetailsTest() {
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomerId(2);
        customerDetails.setCustomerName("Raju");
        when(registrationService.registerCustomerDetails(any())).thenReturn(customerDetails);
        ResponseEntity<CustomerDetails> response = registrationController.registerCustomerDetails(customerDetails);
        verify(registrationService, times(1)).registerCustomerDetails(any());
        assertNotNull(response.getBody());
    }

    @Test
    public void findCustomerDetailsTest() {
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomerId(3);
        customerDetails.setCustomerName("Sree");
        when(registrationService.findCustomerDetails(any())).thenReturn(customerDetails);
        ResponseEntity<CustomerDetails> response = registrationController.findCustomerDetails(222);
        verify(registrationService, times(1)).findCustomerDetails(any());
        assertNotNull(response.getBody());
    }

    @Test
    public void updateCustomerTest() {
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomerId(2);
        customerDetails.setCustomerName("Raj");
        when(registrationService.updateCustomerDetails(any())).thenReturn(customerDetails);
        ResponseEntity<CustomerDetails> response = registrationController.updateCustomer(customerDetails);
        verify(registrationService, times(1)).updateCustomerDetails(any());
        assertNotNull(response.getBody());
    }

}
