package com.example.jasypt.service.impementations;

import com.example.jasypt.dto.ChainObjectDto;
import com.example.jasypt.dto.ChainProcessStrategyEnum;
import com.example.jasypt.service.ChainProcessContext;
import com.example.jasypt.service.interfaces.ChainProcessService;
import com.example.jasypt.service.interfaces.ChainProcessStrategy;
import lombok.RequiredArgsConstructor;

import java.util.LinkedHashSet;

import static com.example.jasypt.dto.ChainProcessStrategyEnum.STRATEGY_B;

@RequiredArgsConstructor
public class B_ChainProcessStrategy implements ChainProcessStrategy {

    private final LinkedHashSet<ChainProcessService<ChainObjectDto>> processServices;
    private final ChainProcessContext context;
    @Override
    public void executeAction(ChainObjectDto chainObject) {
        processServices.forEach(x -> {
            x.checkContractBeforeExecuteAction(context);
            x.executeAction(chainObject);
            x.registerStep(context);
        });
    }

    @Override
    public ChainProcessStrategyEnum getChainProcessStrategy() {
        return STRATEGY_B;
    }

}
