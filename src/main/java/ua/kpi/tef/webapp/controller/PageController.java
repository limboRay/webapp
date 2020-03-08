package ua.kpi.tef.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import ua.kpi.tef.webapp.dto.LanguageDTO;
import ua.kpi.tef.webapp.entity.User;
import ua.kpi.tef.webapp.service.UserService;

import java.util.List;
import java.util.Locale;


@Controller
public class PageController implements WebMvcConfigurer {

	private LanguageDTO languageSwitcher = new LanguageDTO();
	private final UserService userService;

	@Autowired
	public PageController(UserService userService) {
		this.userService = userService;
	}

	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.ENGLISH);
		return localeResolver;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("l"); //token that is expected after /? in url for locale choice
		return localeChangeInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(localeChangeInterceptor());
	}



	@RequestMapping(value = {"/", "/index"})
	public String lobbyPage(@ModelAttribute LanguageDTO language, Model model){
		languageSwitcher.setChoice(LocaleContextHolder.getLocale().toString());
		model.addAttribute("language", languageSwitcher);
		model.addAttribute("supported", languageSwitcher.getSupportedLanguages());

		System.out.println("Obtained locale code from the front end: " + language.getChoice());




		List<User> allUsers = userService.getAllUsers().getUsers();
		if (language.isLocaleCyrillic()){
			for (User user : allUsers) {
				user.setFirstName(user.getFirstNameCyr());
				user.setLastName(user.getLastNameCyr());
			}
		}


		model.addAttribute("language", language);
		model.addAttribute("users", allUsers);
		return "index.html";
	}
}

