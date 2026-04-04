package com.krishna.accounts.service.impl;

import com.krishna.accounts.constants.AccountsConstants;
import com.krishna.accounts.dto.AccountsDto;
import com.krishna.accounts.dto.CustomerDto;
import com.krishna.accounts.entity.Accounts;
import com.krishna.accounts.entity.Customer;
import com.krishna.accounts.exception.CustomerAlreadyExistsException;
import com.krishna.accounts.exception.ResourceNotFoundException;
import com.krishna.accounts.mapper.AccountsMapper;
import com.krishna.accounts.mapper.CustomerMapper;
import com.krishna.accounts.repository.AccountsRepository;
import com.krishna.accounts.repository.CustomerRepository;
import com.krishna.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.lang.module.ResolutionException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
         Customer customer= CustomerMapper.mapToCustomer(customerDto,new Customer());
         Optional<Customer> optionalCustomer=customerRepository.findByMobileNumber(customerDto.getMobileNumber());
         if(optionalCustomer.isPresent()){
             throw new CustomerAlreadyExistsException("Customer already existed"+ customerDto.getMobileNumber());
         }
         Customer savedCustomer=customerRepository.save(customer);
         accountsRepository.save(createNewAccount(savedCustomer));

    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
       Customer customer= customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
               ()->new ResourceNotFoundException("Customer" , "mobileNumber", mobileNumber)
       );
       Accounts accounts=accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
               ()-> new ResourceNotFoundException("Accounts" , "customerId", customer.getCustomerId().toString())
       );
        CustomerDto customerDto=CustomerMapper.mapToCustomerDto(customer,new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts,new AccountsDto()));
        return customerDto ;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated=false;
        AccountsDto accountsDto=customerDto.getAccountsDto();
        if(accountsDto!=null){
           Accounts accounts= accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                   ()-> new ResourceNotFoundException("Account", "accountNumber", accountsDto.getAccountNumber().toString())
           );
           AccountsMapper.mapToAccounts(accountsDto,accounts);
           accounts=accountsRepository.save(accounts);

          Long customerId= accounts.getCustomerId();
          Customer customer=customerRepository.findById(customerId).orElseThrow(
                  ()->new ResourceNotFoundException("Customer", "customerId", customerId.toString())
          );
          CustomerMapper.mapToCustomer(customerDto,customer);
          customerRepository.save(customer);
          isUpdated=true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer= customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
         accountsRepository.deleteByCustomerId(customer.getCustomerId());
         customerRepository.deleteById(customer.getCustomerId());

        return true;
    }

    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccount;
    }



}
