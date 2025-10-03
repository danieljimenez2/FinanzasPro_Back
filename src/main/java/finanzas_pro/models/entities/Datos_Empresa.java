package finanzas_pro.models.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "datos_empresa")
public class Datos_Empresa {

    @Id
    @Column(name = "company_symbol", nullable = false)
    private String companySymbol;

    @Column(name = "CompanyName", nullable = false)
    private String companyName;

    // Getters y setters
    public String getCompanySymbol() {
        return companySymbol;
    }

    public void setCompanySymbol(String companySymbol) {
        this.companySymbol = companySymbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
