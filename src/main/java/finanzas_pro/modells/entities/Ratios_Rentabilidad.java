package finanzas_pro.modells.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ratios_rentabilidad")
public class Ratios_Rentabilidad {


    @Id
    @Column(name = "company_symbol", length = 50, nullable = false)
    private String companySymbol;

    @OneToOne
    @MapsId
    @JoinColumn(name = "company_symbol")
    private Datos_Empresa datosEmpresa;

    @Column(name = "roa", precision = 36, scale = 16)
    private BigDecimal roa;

    @Column(name = "roe", precision = 36, scale = 16)
    private BigDecimal roe;

    @Column(name = "roce", precision = 36, scale = 16)
    private BigDecimal roce;

    public String getCompanySymbol() {
        return companySymbol;
    }

    public void setCompanySymbol(String companySymbol) {
        this.companySymbol = companySymbol;
    }

    public Datos_Empresa getDatosEmpresa() {
        return datosEmpresa;
    }

    public void setDatosEmpresa(Datos_Empresa datosEmpresa) {
        this.datosEmpresa = datosEmpresa;
    }

    public BigDecimal getRoa() {
        return roa;
    }

    public void setRoa(BigDecimal roa) {
        this.roa = roa;
    }

    public BigDecimal getRoe() {
        return roe;
    }

    public void setRoe(BigDecimal roe) {
        this.roe = roe;
    }

    public BigDecimal getRoce() {
        return roce;
    }

    public void setRoce(BigDecimal roce) {
        this.roce = roce;
    }
}
