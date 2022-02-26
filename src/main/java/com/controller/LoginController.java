package com.controller;

import com.Routes;
import com.services.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static com.Constants.ERROR_PULLING_DB_DATA;
import static com.Constants.MODAL_MAP_ERRORS;
import static com.Constants.MODAL_MAP_FAILED_RESULT;
import static com.Constants.MODAL_MAP_RESULT;
import static com.Constants.MODAL_MAP_SUCCESS_RESULT;

@RestController
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@GetMapping(value = Routes.WHITE_SOURCE_FULL_STACK)
	@ResponseBody
	public ModelMap loginWithHibernate(HttpServletRequest request,
									   @PathVariable("userName") String userName,
									   @PathVariable("password") String password) {
		ModelMap model = null;

		try {
			model = new ModelMap();
			boolean isValid = loginService.validateEmployee(userName, password);
			String response = isValid ? MODAL_MAP_SUCCESS_RESULT : MODAL_MAP_FAILED_RESULT;
			model.addAttribute(MODAL_MAP_RESULT, response);
		} catch (Exception e) {
			model.addAttribute(MODAL_MAP_ERRORS, e);
			logger.error(ERROR_PULLING_DB_DATA, e.getMessage());
		}

		return model;
	}
}
