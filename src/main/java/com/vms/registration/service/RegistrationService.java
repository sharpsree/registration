package com.vms.registration.service;

import com.vms.registration.entity.CustomerDetails;
import com.vms.registration.repository.CustomerDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegistrationService {
    private final CustomerDetailsRepository customerDetailsRepository;

    public CustomerDetails findCustomerDetails(Integer loginid){
        return customerDetailsRepository.findByLogInId(loginid).stream().findFirst().orElse(null);
    }

    public CustomerDetails registerCustomerDetails(CustomerDetails customer){
        return customerDetailsRepository.save(customer);
    }

    public CustomerDetails updateCustomerDetails(CustomerDetails customer){
        return customerDetailsRepository.save(customer);
    }

}
