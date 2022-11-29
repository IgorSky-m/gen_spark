package edu.genspark.system.utills.api;

import edu.genspark.entity.BaseStudent;

public interface IContextProcessor {

    IContextProcessor printContainerBeanNames();
    IContextProcessor printContextInfo(Class<? extends BaseStudent> studentClass, String...identifiers);

    void closeContext();
}
