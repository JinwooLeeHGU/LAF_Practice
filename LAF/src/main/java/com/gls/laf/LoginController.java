package com.gls.laf;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


//import lombok.Value;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value="/login")
public class LoginController {
	
	final static String GOOGLE_AUTH_BASE_URL = "https://accounts.google.com/o/oauth2/v2/auth";
	final static String GOOGLE_TOKEN_BASE_URL = "https://oauth2.googleapis.com/token";
	final static String GOOGLE_REVOKE_TOKEN_BASE_URL = "https://oauth2.googleapis.com/revoke";
	
	@Value("${api.client_id}")
	String clientId;
	@Value("${api.client_secret}")
	String clientSecret;
	
//	@Autowired
//	private GoogleConnectionFactory googleConnectionFactory;
//	@Autowired
//	private OAuth2Parameters googleOAuth2Parameters;

	@RequestMapping(value="/google", method=RequestMethod.GET)
	public String google(RedirectAttributes rttr, Model model) {
		String url = "redirect:https://accounts.google.com/o/oauth2/v2/auth?client_id=1091952631277-n44a5kuq13om818ukiqur5o0q9jrluko.apps.googleusercontent.com&redirect_uri=http://localhost:8080/laf/login/oauth2callback&response_type=code&scope=email%20profile%20openid&access_type=offline";
		return url;
	}
	
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(String t, Model model) {

		return "login";
	}
	

	
//	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
