package edu.genspark.examples.xml;

import edu.genspark.examples.xml.entity.XmlStudent;
import edu.genspark.system.utills.ContextProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlExampleMain {
    public static void main(String[] args) {
        new ContextProcessor(new ClassPathXmlApplicationContext("XmlExampleContext.xml"))
                .printContainerBeanNames()
                .printContextInfo(XmlStudent.class)
                .closeContext();
    }
}