package com.example.jasypt.service.interfaces;

import com.example.jasypt.dto.ChainObjectDto;
import com.example.jasypt.dto.ChainProcessStrategyEnum;

public interface ChainProcessStrategy extends ChainProcessService<ChainObjectDto> {

    ChainProcessStrategyEnum getChainProcessStrategy();

}
