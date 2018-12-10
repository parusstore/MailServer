package com.padma.parus.store.mail.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

@Configuration
@PropertySource("vault-config.properties")
class VaultConfiguration extends AbstractVaultConfiguration {
 
  @Override
  public VaultEndpoint vaultEndpoint() {
	  VaultEndpoint vaultendpoint= new VaultEndpoint();
	  vaultendpoint.setScheme(getEnvironment().getProperty("spring.vault.scheme"));
	  vaultendpoint.setHost(getEnvironment().getProperty("spring.vault.host"));
	  vaultendpoint.setPort(Integer.parseInt(getEnvironment().getProperty("spring.vault.port")));
	  return vaultendpoint;
    
  }

  @Override
  public ClientAuthentication clientAuthentication() {
    return new TokenAuthentication(getEnvironment().getProperty("spring.vault.token"));
  }
}
