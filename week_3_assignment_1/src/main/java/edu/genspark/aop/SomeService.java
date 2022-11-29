package edu.genspark.aop;

import edu.genspark.aop.annotations.AopCustomLog;
import edu.genspark.aop.annotations.ValueCheck;
import edu.genspark.aop.api.IService;
import org.springframework.stereotype.Service;

@Service("service")
public class SomeService implements IService {
    @AopCustomLog
    @Override
    public void doWork() {
        System.out.println("do some work");
    }

    @AopCustomLog
    @ValueCheck("Hello AOP")
    @Override
    public void doWorkWithValue(String value) {
        System.out.println("value = " + value);
    }
}
