package edu.genspark.examples.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("edu.genspark.examples.aop")
@Configuration
@EnableAspectJAutoProxy
public class AopApplicationConfiguration {


}
