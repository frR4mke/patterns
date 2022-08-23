package com.example.jasypt.service;

import com.example.jasypt.dto.ChainObjectDto;
import com.example.jasypt.dto.ChainProcessStrategyEnum;
import com.example.jasypt.service.interfaces.ChainProcessStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ChainProcessFacade {

    private final Map<ChainProcessStrategyEnum, ChainProcessStrategy> chainProcessStrategyMap;

    public void executeAction(ChainProcessStrategyEnum strategy, ChainObjectDto chainObjectDto) {
        if (Boolean.FALSE.equals(chainProcessStrategyMap.containsKey(strategy))) {
            throw new IllegalArgumentException("Для переданного типа запроса не найден сервис обработки");
        }
        chainProcessStrategyMap.get(strategy).executeAction(chainObjectDto);
    }

}
