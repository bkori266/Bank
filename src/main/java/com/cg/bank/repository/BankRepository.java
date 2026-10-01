package com.cg.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.bank.domain.BankAccount;

import feign.Param;

@Repository
public interface BankRepository extends JpaRepository<BankAccount, Long> {
	
	
	@Query("SELECT b FROM BankAccount b WHERE b.customerId=:id ")
	public List<BankAccount> findByCustomerId(@Param("id") Long id);

}
