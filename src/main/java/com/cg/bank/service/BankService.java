package com.cg.bank.service;

import java.util.List;
import java.util.Optional;

import com.cg.bank.domain.BankAccount;

public interface BankService {
	
	public BankAccount save(BankAccount bank);
		
	public BankAccount getAccountByAccountId(Long accountid);
	
	public List<BankAccount> getAccountByCustomerid(Long customerId);
	
	public List<BankAccount> getAll();
	
	public void deleteAccountByAccountId(Long accountid);
	
	
	

}
