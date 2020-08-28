package com.vms.registration.controller.com.vms.registration.service;

import com.vms.registration.entity.CustomerDetails;
import com.vms.registration.repository.CustomerDetailsRepository;
import com.vms.registration.service.RegistrationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class RegistrationServiceTest {
    @InjectMocks
    private RegistrationService registrationService;

    @Mock
    private CustomerDetailsRepository customerDetailsRepository;

    @Test
    public void findCustomerDetailsTest() {
        List<CustomerDetails> customerDetail = new ArrayList<>();
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomerId(2);
        customerDetails.setCustomerName("Raju");
        customerDetail.add(customerDetails);
        when(customerDetailsRepository.findByLogInId(any())).thenReturn(customerDetail);
        CustomerDetails response = registrationService.findCustomerDetails(3);
        verify(customerDetailsRepository, times(1)).findByLogInId(any());
        assertNotNull(response);
    }

    @Test
    public void registerCustomerDetailsTest() {
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomerId(2);
        customerDetails.setCustomerName("Sree");
        when(customerDetailsRepository.save(any())).thenReturn(customerDetails);
        CustomerDetails response = registrationService.registerCustomerDetails(customerDetails);
        verify(customerDetailsRepository, times(1)).save(any());
        assertNotNull(response);
    }

    @Test
    public void updateCustomerDetailsTest() {
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setCustomerId(2);
        customerDetails.setCustomerName("Ramesh");
        when(customerDetailsRepository.save(any())).thenReturn(customerDetails);
        CustomerDetails response = registrationService.updateCustomerDetails(customerDetails);
        verify(customerDetailsRepository, times(1)).save(any());
        assertNotNull(response);
    }

}
