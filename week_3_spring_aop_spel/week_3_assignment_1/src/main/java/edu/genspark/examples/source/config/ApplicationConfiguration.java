package edu.genspark.examples.source.config;

import edu.genspark.entity.api.IAddress;
import edu.genspark.entity.api.IPhone;
import edu.genspark.entity.api.IStudent;
import edu.genspark.examples.source.entity.SourceAddress;
import edu.genspark.examples.source.entity.SourceStudent;
import edu.genspark.examples.source.entity.SourcePhone;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@ComponentScan("edu.genspark.source")
@Configuration
public class ApplicationConfiguration {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public IPhone phone(){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return new SourcePhone(
                new StringBuilder("(")
                        .append(random.nextInt(100, 999 ))
                        .append(")")
                        .append(random.nextInt(100, 999 ))
                        .append("-")
                        .append(random.nextInt(1000, 9999))
                        .toString()
        );
    }

    @Bean
    public IAddress address(){
        IAddress address = new SourceAddress();
        address.setCity("Chicago");
        address.setCountry("USA");
        address.setState("IL");
        address.setZipcode("60001");
        return address;
    }

    @Bean(initMethod = "startUp", destroyMethod = "shutDown")
    public IStudent student(IAddress address, IPhone phone1, IPhone phone2){
        return new SourceStudent(
                ThreadLocalRandom.current().nextInt(),
                "Source Student",
                List.of(phone1, phone2),
                address
        );
    }

}
