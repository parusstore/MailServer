package com.padma.parus.store.mail.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**import org.springframework.context.annotation.Import;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;**/



@SpringBootApplication
@ComponentScan("com.padma.parus.store.mail.service")
public class MailServiceForParusStoreApplication {




	 
	public static void main(String[] args) {
		/**VaultEndpoint endpoint = VaultEndpoint.create("127.0.0.1", 8200);
		endpoint.setScheme("http");
		VaultTemplate vaultTemplate = new VaultTemplate(endpoint,
                new TokenAuthentication("00000000-0000-0000-0000-000000000000"));
		
        Secrets secrets = new Secrets();
        secrets.username = "hello";
        secrets.password = "world";

        vaultTemplate.write("parusstore/myapp", secrets);

        VaultResponseSupport<Secrets> response = vaultTemplate.read("parusstore/myapp", Secrets.class);
        System.out.println("***************"+response.getData().getUsername());**/


        
		SpringApplication.run(MailServiceForParusStoreApplication.class, args);
		
	}
}
