package com.cg.bank.controller;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bank.domain.BankAccount;
import com.cg.bank.service.BankService;

import jakarta.ws.rs.Path;

@RestController
@RequestMapping("/v1/account")
public class BankController {
	
	@Autowired
	BankService bankService;	
	
	private static final Logger logger=LoggerFactory.getLogger(BankController.class);	
	
	@GetMapping("/")
	public ResponseEntity<String> message() {
		logger.info("----Hello method---Controller-----Bank Microservices");
		return new ResponseEntity<String>("Hello from Bank-Microservice", HttpStatus.OK) ;
	}
	
	@GetMapping("customer/{customerId}")
	public ResponseEntity<List<BankAccount>> getBankByCustomerId(@PathVariable Long customerId) {
		logger.info("----GetCustomerById----Controllert---BankMicroservice");
		return ResponseEntity.status(HttpStatus.OK).body(bankService.getAccountByCustomerid(customerId));
	}
	
	@PostMapping("/save")
	public void save(@RequestBody BankAccount bank) {
		logger.info("Save account method called");
				bankService.save(bank);
		logger.info("Account saved successfully "+bank);
	}

	@GetMapping("/{accountid}")
	public BankAccount getById(@PathVariable Long accountid) {	
		logger.info("Get account by id method called");
		return bankService.getAccountByAccountId(accountid);
	}

	@GetMapping("/getAll")
	public List<BankAccount> getAll() {	
		logger.info("Get all account method called");
		return bankService.getAll();
		
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteById(@PathVariable Long accountid) {
		logger.info("Delete account by id method called");
		bankService.deleteAccountByAccountId(accountid);
	}
	

}
