package com.example.jasypt.config;

import com.example.jasypt.dto.ChainProcessStrategyEnum;
import com.example.jasypt.service.ChainProcessContext;
import com.example.jasypt.service.impementation.FirstChainService;
import com.example.jasypt.service.impementation.SecondChainService;
import com.example.jasypt.service.impementation.ThirdChainService;
import com.example.jasypt.service.impementations.A_ChainProcessStrategy;
import com.example.jasypt.service.impementations.B_ChainProcessStrategy;
import com.example.jasypt.service.interfaces.ChainProcessStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class ChainProcessConfiguration {

    @Bean
    public Map<ChainProcessStrategyEnum, ChainProcessStrategy> chainProcessStrategy(Set<ChainProcessStrategy> chainProcessStrategySet) {
        return chainProcessStrategySet.stream()
                                      .collect(Collectors.toMap(ChainProcessStrategy::getChainProcessStrategy,
                                                                Function.identity()));
    }

    @Bean
    public A_ChainProcessStrategy a_chainProcessStrategy(ChainProcessContext context,
                                                         FirstChainService firstChainService,
                                                         SecondChainService secondChainService,
                                                         ThirdChainService thirdChainService) {
        return new A_ChainProcessStrategy(new LinkedHashSet<>(List.of(firstChainService,
                                                                      secondChainService,
                                                                      thirdChainService)), context);
    }

    @Bean
    public B_ChainProcessStrategy b_chainProcessStrategy(ChainProcessContext context,
                                                         FirstChainService firstChainService,
                                                         SecondChainService secondChainService) {
        return new B_ChainProcessStrategy(new LinkedHashSet<>(List.of(firstChainService,
                                                                      secondChainService)), context);
    }

}
