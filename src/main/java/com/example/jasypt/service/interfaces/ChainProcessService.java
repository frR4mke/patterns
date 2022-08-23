package com.example.jasypt.service.interfaces;

import com.example.jasypt.service.ChainProcessContext;

import java.beans.Introspector;

public interface ChainProcessService<T extends ChainObject> {

    default void checkContractBeforeExecuteAction(ChainProcessContext context) {

    }

    void executeAction(T chainObject);

    default void registerStep(ChainProcessContext context) {
        context.registerExecutedStep(Introspector.decapitalize(this.getClass().getSimpleName()));
    }

}
