package co.grandcircus.awsencryptdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@Value("${db.apikey}")
	private String apikey;
	
	@GetMapping("/")
	public String index() {
		System.out.println("THE API KEY IS " + apikey);
		return "index";
	}
}
