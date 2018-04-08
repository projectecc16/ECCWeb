package com.eccweb.service;

import com.eccweb.entity.KeyStore;
import com.eccweb.resource.CryptoResource;

public interface CryptoService {
	public CryptoResource encrypt(KeyStore keyStore, CryptoResource decData);
    public CryptoResource decrypt(KeyStore keyStore, CryptoResource encData);
}
