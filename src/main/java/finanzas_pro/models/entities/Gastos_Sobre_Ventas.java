package finanzas_pro.models.entities;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "gastos_sobre_ventas")
public class Gastos_Sobre_Ventas {

    @Id
    @Column(name = "company_symbol", length = 50, nullable = false)
    private String companySymbol;

    @OneToOne
    @MapsId
    @JoinColumn(name = "company_symbol")
    private Datos_Empresa datosEmpresa;

    @Column(name = "svg_to_revenue_ttm", precision = 36, scale = 16)
    private BigDecimal svgToRevenueTtm;

    @Column(name = "i+d_to_revenue_ttm", precision = 36, scale = 16)
    private BigDecimal iMasdToRevenueTtm;

    @Column(name = "capex_to_cfo_ttm", precision = 36, scale = 16)
    private BigDecimal capexToCfoTtm;

    @Column(name = "capex_to_revenue_ttm", precision = 36, scale = 16)
    private BigDecimal capexToRevenueTtm;

    @Column(name = "sbc_to_revenue_ttm", precision = 36, scale = 16)
    private BigDecimal sbcToRevenueTtm;

    @Column(name = "revenues")
    private Long revenues;

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

    public BigDecimal getSvgToRevenueTtm() {
        return svgToRevenueTtm;
    }

    public void setSvgToRevenueTtm(BigDecimal svgToRevenueTtm) {
        this.svgToRevenueTtm = svgToRevenueTtm;
    }

    public BigDecimal getiMasdToRevenueTtm() {
        return iMasdToRevenueTtm;
    }

    public void setiMasdToRevenueTtm(BigDecimal iMasdToRevenueTtm) {
        this.iMasdToRevenueTtm = iMasdToRevenueTtm;
    }

    public BigDecimal getCapexToCfoTtm() {
        return capexToCfoTtm;
    }

    public void setCapexToCfoTtm(BigDecimal capexToCfoTtm) {
        this.capexToCfoTtm = capexToCfoTtm;
    }

    public BigDecimal getCapexToRevenueTtm() {
        return capexToRevenueTtm;
    }

    public void setCapexToRevenueTtm(BigDecimal capexToRevenueTtm) {
        this.capexToRevenueTtm = capexToRevenueTtm;
    }

    public BigDecimal getSbcToRevenueTtm() {
        return sbcToRevenueTtm;
    }

    public void setSbcToRevenueTtm(BigDecimal sbcToRevenueTtm) {
        this.sbcToRevenueTtm = sbcToRevenueTtm;
    }

    public Long getRevenues() {
        return revenues;
    }

    public void setRevenues(Long revenues) {
        this.revenues = revenues;
    }
}
