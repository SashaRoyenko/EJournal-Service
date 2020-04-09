package com.robosh.ejournal.factory;


import com.robosh.ejournal.service.ValidationService;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BeansFactory {

    private static final BeansFactory INSTANCE = new BeansFactory();

    private ValidationService validationService;

    private BeansFactory() {
    }

    public static BeansFactory getInstance() {
        return INSTANCE;
    }

}
