package com.eccweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eccweb.crypto.ECCUtil;
import com.eccweb.crypto.PairKey;
import com.eccweb.repository.AccountRepository;
import com.eccweb.entity.Account;
import com.eccweb.service.AccountService;
import com.eccweb.service.exception.DoesNotExistException;
import com.eccweb.service.exception.ExistsException;


@Service(value="accountService")
@Transactional
public class AccountServiceImpl implements com.eccweb.service.AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findAccount(Long id) {
        return accountRepository.findOne(id);
    }

    @Override
    public Account createAccount(Account data) {
        Account account = accountRepository.findByUsername(data.getUsername());
        if(account != null)
        {
            throw new ExistsException();
        }
        account = accountRepository.save(data);
        //updateKey(account.getId());
        return account;
    }

    @Override
    public Account findByAccountName(String name) {
        return accountRepository.findByUsername(name);
    }

	@Override
	public void updateKey(Long id) {
		Account account = accountRepository.findOne(id);
        if(account == null)
        {
            throw new DoesNotExistException();
        }
        PairKey pairKey = ECCUtil.generateECKeys();
        accountRepository.updateKey(id, pairKey.getPrivateKey(),pairKey.getPublicKey());
        return;
	}

	@Override
	public void updateRemoteKey(Long id, String remoteKey, String privateKey) {
		Account account = accountRepository.findOne(id);
        if(account == null)
        {
            throw new DoesNotExistException();
        }
        String sharedKey = ECCUtil.generateSharedSecret(privateKey,remoteKey);
        
        accountRepository.updateRemoteKey(id, remoteKey,sharedKey);
        return;
	}
}
