package edu.genspark.examples.annotation.config;

import edu.genspark.system.YamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//Can use this file or setup property source at xml
@Configuration
@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
public class AppConfig {
}
