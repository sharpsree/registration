package com.vms.registration.controller;

import com.vms.registration.entity.CustomerDetails;
import com.vms.registration.service.RegistrationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@Log4j2
@RestController
@Validated
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    @PostMapping ("/registercustomerdetails")
    public ResponseEntity<CustomerDetails> registerCustomerDetails(@RequestBody CustomerDetails customer) {
        log.info(" Register Customer");
        return new ResponseEntity<>(registrationService.registerCustomerDetails(customer), HttpStatus.CREATED);
    }

    @GetMapping("/findcustomerdetails/{loginid}")
    public ResponseEntity<CustomerDetails> findCustomerDetails(@PathVariable  @Min(1) Integer loginid) {
        log.info(" find CustomerDetails  for loginid: {}", loginid);
        return new ResponseEntity<>(registrationService.findCustomerDetails(loginid), HttpStatus.OK);
    }

    @PutMapping("/updatecustomerdetails")
    public ResponseEntity<CustomerDetails> updateCustomer(@RequestBody CustomerDetails customer) {
        log.info(" Update Customer");
        return new ResponseEntity<>(registrationService.updateCustomerDetails(customer), HttpStatus.ACCEPTED);
    }
}
