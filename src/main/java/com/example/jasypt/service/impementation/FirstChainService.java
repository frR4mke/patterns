package com.example.jasypt.service.impementation;

import com.example.jasypt.dto.ChainObjectDto;
import com.example.jasypt.service.ChainProcessContext;
import com.example.jasypt.service.interfaces.ChainObject;
import com.example.jasypt.service.interfaces.ChainProcessService;
import org.springframework.stereotype.Service;

@Service
public class FirstChainService implements ChainProcessService<ChainObjectDto> {

    @Override
    public void executeAction(ChainObjectDto chainObject) {
        System.out.println("First step was executed");
    }

}
