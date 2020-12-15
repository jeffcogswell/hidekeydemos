package co.grandcircus.awsencryptdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	// Don't lose track! We have two keys, the API key and the encryption key.
	// For now we're hardcoding the encryptiong key so that the application.properties
	// file doesn't have the API key shown in clear text.
	
	@Value("${db.apikey}")
	private String encryptedApikey;
	
	AESEncryptionDecryption aes = new AESEncryptionDecryption();	
	private String encryptkey = "A4IIH983";
	
	private String privateApiKey = null;
	private String getApiKey() {
		if (privateApiKey == null) {
			privateApiKey = aes.decrypt(encryptedApikey, encryptkey);
		}
		return privateApiKey;
	}
	
	@GetMapping("/")
	public String index() {
		
		// First time we run it, generate the key so we can save that in the application.properties file instead
		//System.out.println(aes.encrypt("ABC123", encryptkey));
		
		System.out.println("THE API KEY IS " + getApiKey());
		return "index";
	}

}
