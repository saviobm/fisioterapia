package br.com.fisioterapia.fisioterapia.propriedades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/fisioterapia.properties")
public class FisioterapiaProperties {

	@Autowired
	Environment env;

	public String getPropriedade(String key) {
		return env.getProperty(key);
	}

}
