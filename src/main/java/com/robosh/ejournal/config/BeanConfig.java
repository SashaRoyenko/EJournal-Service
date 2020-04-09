package com.robosh.ejournal.config;


import com.robosh.ejournal.factory.BeansFactory;
import com.robosh.ejournal.service.ValidationService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

    @Bean
    public BeansFactory getBeansFactory(ValidationService validationService) {
        final BeansFactory beansFactory = BeansFactory.getInstance();
        beansFactory.setValidationService(validationService);
        return beansFactory;
    }

}
