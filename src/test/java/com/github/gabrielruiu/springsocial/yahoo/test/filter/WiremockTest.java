package com.github.gabrielruiu.springsocial.yahoo.test.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.gabrielruiu.springsocial.yahoo.module.YahooModule;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

/**
 * @author Gabriel Mihai Ruiu (gabriel.ruiu@mail.com)
 */
public abstract class WiremockTest {

	protected static final String GUID = "my-yahoo-guid";

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(wireMockConfig().dynamicPort());

	protected ResponseDefinitionBuilder successfulJsonResponse(String bodyFile) {
		return aResponse()
				.withHeader("Content-Type", "application/json")
				.withStatus(200)
				.withBodyFile(bodyFile);
	}

	protected String apiUrlBaseForTest() {
		return "http://localhost:" + wireMockRule.port();
	}

	protected RestTemplate restTemplate() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new YahooModule());
		MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(objectMapper);
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(jacksonConverter);
		return new RestTemplate(converters);
	}
}
