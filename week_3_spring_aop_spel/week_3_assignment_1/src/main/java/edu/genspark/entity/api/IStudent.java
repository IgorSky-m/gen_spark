package edu.genspark.entity.api;

import java.util.List;

public interface IStudent {
    int getId();
    void setId(int id);

    String getName();
    void setName(String name);

    List<IPhone> getPh();
    void setPh(List<IPhone> ph);

    IAddress getAdd();
    void setAdd(IAddress add);
}
