package edu.genspark.system.utills.api;

import edu.genspark.entity.BaseStudent;
import edu.genspark.entity.api.IStudent;

public interface IContextProcessor {

    IContextProcessor printContainerBeanNames();
    IContextProcessor printContextInfo(Class<? extends IStudent> studentClass, String...identifiers);

    <T> T getBean(String id);
    void closeContext();
}
