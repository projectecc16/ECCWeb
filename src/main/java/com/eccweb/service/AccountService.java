package com.eccweb.service;

import com.eccweb.entity.Account;

public interface AccountService {
    public Account findAccount(Long id);
    public Account createAccount(Account data);
    public Account findByAccountName(String name);
    public void updateKey(Long id);
    public void updateRemoteKey(Long id, String remoteKey, String privateKey);
}
