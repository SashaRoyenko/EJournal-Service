package com.robosh.ejournal.factory;


import com.robosh.ejournal.data.repository.ValidationRepository;
import com.robosh.ejournal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
@Configuration
public class BeansFactory {

    @Autowired
    private ValidationRepository validationRepository;

    private AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public ValidationRepository getValidationRepository() {
        return validationRepository;
    }

    public AdminService getAdminService() {
        return adminService;
    }
}
