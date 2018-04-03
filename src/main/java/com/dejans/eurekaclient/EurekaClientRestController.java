package com.dejans.eurekaclient;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

@RestController
class EurekaClientRestController {

	protected Logger logger = Logger.getLogger(EurekaClientRestController.class.getName());

	@RequestMapping("/testnew/")
	public String root(HttpServletRequest req) {
		logger.info("test-new root() invoked");
		return "TestNew tekst " + req.getPathInfo();

	}

	@RequestMapping("/testnew/**")
	public String others(HttpServletRequest req) {
		logger.info("test-new OTHERS() invoked");
		return "Wrong CALL (" + req.getPathInfo() + ") in TestNew. Ask administrator ";
	}

	@RequestMapping("/**")
	public String all3(HttpServletRequest req) {
		final String serviceUrl3 = "http://PROBA3-MICROSERVICE";
		String restOfTheUrl = (String) req.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		String queryString = (String) req.getQueryString();
		logger.info("proba3-microservice all() invoked 3");
		return restOfTheUrl + " ???? "+ queryString;

	}

}