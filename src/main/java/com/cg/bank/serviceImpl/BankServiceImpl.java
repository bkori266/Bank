package com.cg.bank.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bank.domain.BankAccount;
import com.cg.bank.exception.NoBankFoundException;
import com.cg.bank.repository.BankRepository;
import com.cg.bank.service.BankService;

@Service
public class BankServiceImpl implements BankService {
	
	@Autowired
	BankRepository bankRepository;
	
	BankAccount bankAccount;
	
	private static final Logger logger=LoggerFactory.getLogger(BankServiceImpl.class);

	@Override
	public BankAccount save(BankAccount bank) {
		logger.info("--------Save method---Service class---Bank microservices");
		return bankRepository.save(bank);

	}

	@Override
	public BankAccount getAccountByAccountId(Long accountid) {		
		logger.info("--------GetAccountById---Service class---Bank microservices");
		return bankRepository.findById(accountid).orElseThrow(()->new NoBankFoundException("No bank found"));
	}

	@Override
	public List<BankAccount> getAll() {		
		logger.info("--------GetAll---Service class---Bank microservices");
		return bankRepository.findAll();
	}

	@Override
	public void deleteAccountByAccountId(Long accountid) {
		logger.info("--------Delete method---Service class---Bank microservices");
		 bankRepository.deleteById(accountid);
	}

	@Override
	public List<BankAccount> getAccountByCustomerid(Long customerId) {
		logger.info("--------AccountByCustomerId---Service class---Bank microservices");
		return bankRepository.findByCustomerId(customerId);
	}

}
