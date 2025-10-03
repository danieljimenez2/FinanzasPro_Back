package finanzas_pro.controllers;


import finanzas_pro.models.entities.Datos_Empresa;
import finanzas_pro.services.DatosEmpresaYCompañiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class Datos_Empresa_Controller {

    @Autowired
    private DatosEmpresaYCompañiaService datosEmpresaYCompañiaService;

    @GetMapping("/list")
    public List<Datos_Empresa> getCompanies() {
        return datosEmpresaYCompañiaService.getFirst15Companies();
    }

    @GetMapping("/search")
    public List<Datos_Empresa> searchCompanies(String q) {
        return datosEmpresaYCompañiaService.searchCompanies(q);
    }

}
