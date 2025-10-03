package finanzas_pro.models.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "dividendos")
public class Dividendos {

    @Id
    @Column(name = "company_symbol", length = 50, nullable = false)
    private String companySymbol;

    @OneToOne
    @MapsId // comparte PK con datos_compania
    @JoinColumn(name = "company_symbol")
    private Datos_Empresa datosEmpresa;

    @Column(name = "dividend_yield_ttm", precision = 36, scale = 16)
    private BigDecimal dividendYieldTtm;

    @Column(name = "payoutRatioTTM", precision = 36, scale = 16)
    private BigDecimal payoutRatioTtm;

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

    public BigDecimal getDividendYieldTtm() {
        return dividendYieldTtm;
    }

    public void setDividendYieldTtm(BigDecimal dividendYieldTtm) {
        this.dividendYieldTtm = dividendYieldTtm;
    }

    public BigDecimal getPayoutRatioTtm() {
        return payoutRatioTtm;
    }

    public void setPayoutRatioTtm(BigDecimal payoutRatioTtm) {
        this.payoutRatioTtm = payoutRatioTtm;
    }
}
