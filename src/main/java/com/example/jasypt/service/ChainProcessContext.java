package com.example.jasypt.service;

import com.example.jasypt.dto.ChainObjectDto;
import com.example.jasypt.service.interfaces.ChainObject;
import com.example.jasypt.service.interfaces.ChainProcessService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.beans.Introspector;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChainProcessContext {

    private Set<String> registeredSteps;

    public void registerExecutedStep(String executedStep) {
        registeredSteps.add(executedStep);
    }

    public Boolean isStepWasExecuted(Class<? extends ChainProcessService<ChainObjectDto>> tClass) {
        return registeredSteps.contains(Introspector.decapitalize(tClass.getSimpleName()));
    }

    public Boolean isStepWasExecuted(Set<Class<? extends ChainProcessService<ChainObjectDto>>> tClasses) {
        Set<String> stepDecapitalizedNames =
                tClasses.stream().map(x -> Introspector.decapitalize(x.getSimpleName())).collect(Collectors.toSet());
        return registeredSteps.containsAll(stepDecapitalizedNames);
    }

}
