package com.example.jasypt.service.interfaces;

import com.example.jasypt.dto.ChainObjectDto;
import com.example.jasypt.service.ChainProcessContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public abstract class ChainProcessAbstractService implements ChainProcessService<ChainObjectDto> {

    private final ChainProcessContext context;

    public void executeActionWithFixExecutedStep(ChainProcessContext context,ChainObjectDto chainObjectDto) {
        executeAction(chainObjectDto);
    }

}
