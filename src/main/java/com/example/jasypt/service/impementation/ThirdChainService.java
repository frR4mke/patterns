package com.example.jasypt.service.impementation;

import com.example.jasypt.dto.ChainObjectDto;
import com.example.jasypt.service.ChainProcessContext;
import com.example.jasypt.service.interfaces.ChainProcessService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ThirdChainService implements ChainProcessService<ChainObjectDto> {

    @Override
    public void checkContractBeforeExecuteAction(ChainProcessContext context) {
        if (!context.isStepWasExecuted(Set.of(FirstChainService.class, SecondChainService.class))) {
            throw new IllegalArgumentException("Не был соблюден контракт сервиса. Не был выполнен шаг - " +
                                               FirstChainService.class.getSimpleName() + "," +
                                               SecondChainService.class.getSimpleName());
        }
    }

    @Override
    public void executeAction(ChainObjectDto chainObject) {
        System.out.println("Third step was executed");
    }

}
