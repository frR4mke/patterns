package com.example.jasypt.service.impementation;

import com.example.jasypt.dto.ChainObjectDto;
import com.example.jasypt.service.ChainProcessContext;
import com.example.jasypt.service.interfaces.ChainProcessService;
import org.springframework.stereotype.Service;

@Service
public class SecondChainService implements ChainProcessService<ChainObjectDto> {

    @Override
    public void checkContractBeforeExecuteAction(ChainProcessContext context) {
        if (!context.isStepWasExecuted(FirstChainService.class)) {
            throw new IllegalArgumentException("Не был соблюден контракт сервиса. Не был выполнен шаг - " +
                                               FirstChainService.class.getSimpleName());
        }
    }

    @Override
    public void executeAction(ChainObjectDto chainObject) {
        System.out.println("Second step was executed");
    }

}
