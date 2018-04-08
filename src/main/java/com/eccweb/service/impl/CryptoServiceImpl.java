package com.eccweb.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.eccweb.crypto.ECCUtil;
import com.eccweb.entity.KeyStore;
import com.eccweb.resource.CryptoResource;
import com.eccweb.service.CryptoService;
@Service(value="cryptoService")
@Transactional
public class CryptoServiceImpl implements CryptoService {

	@Override
	public CryptoResource encrypt(KeyStore keyStore,CryptoResource decData) {
		String key = ECCUtil.generateSharedSecret(keyStore.getPrivateKey(),
				keyStore.getRemoteKey());
		String value = ECCUtil.encryptString(key, decData.getCrypta());
		return new CryptoResource(value);
	}

	@Override
	public CryptoResource decrypt(KeyStore keyStore,CryptoResource encData) {
		String key = ECCUtil.generateSharedSecret(keyStore.getPrivateKey(),
				keyStore.getRemoteKey());
		String value = ECCUtil.decryptString(key, encData.getCrypta());
		return new CryptoResource(value);
	}
	

}
