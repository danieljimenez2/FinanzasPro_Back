package finanzas_pro.controllers;


import finanzas_pro.modells.entities.Datos_Empresa;
import finanzas_pro.services.GetCompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class Company_Info_Controller {

    @Autowired
    private GetCompanyInfoService getCompanyInfoService;

    @GetMapping("/list")
    public List<Datos_Empresa> getCompanies() {
        return getCompanyInfoService.getFirst15Companies();
    }
    @GetMapping("/search")
    public List<Datos_Empresa> searchCompanies(String q) {
        return getCompanyInfoService.searchCompanies(q);
    }
}
