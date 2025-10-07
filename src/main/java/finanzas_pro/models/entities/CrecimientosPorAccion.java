package finanzas_pro.models.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "crecimientos_por_accion")
public class CrecimientosPorAccion {
    @Id
    @Column(name = "company_symbol", length = 50, nullable = false)
    private String companySymbol;

    @OneToOne
    @MapsId
    @JoinColumn(name = "company_symbol")
    private DatosEmpresa datosEmpresa;

    @Column(name = "revenues_cagr_10y", precision = 36, scale = 16)
    private BigDecimal revenuesCagr10y;

    @Column(name = "revenues_cagr_5y", precision = 36, scale = 16)
    private BigDecimal revenuesCagr5y;

    @Column(name = "cashflow_cagr_10y", precision = 36, scale = 16)
    private BigDecimal cashflowCagr10y;

    @Column(name = "cashflow_cagr_5y", precision = 36, scale = 16)
    private BigDecimal cashflowCagr5y;

    @Column(name = "eps_cagr_10y", precision = 36, scale = 16)
    private BigDecimal epsCagr10y;

    @Column(name = "eps_cagr_5y", precision = 36, scale = 16)
    private BigDecimal epsCagr5y;

    @Column(name = "equity_cagr_5y", precision = 36, scale = 16)
    private BigDecimal equityCagr5y;

    @Column(name = "dividends_cagr_10y", precision = 36, scale = 16)
    private BigDecimal dividendsCagr10y;

    @Column(name = "dividends_cagr_5y", precision = 36, scale = 16)
    private BigDecimal dividendsCagr5y;

    public String getCompanySymbol() {
        return companySymbol;
    }

    public void setCompanySymbol(String companySymbol) {
        this.companySymbol = companySymbol;
    }

    public DatosEmpresa getDatosEmpresa() {
        return datosEmpresa;
    }

    public void setDatosEmpresa(DatosEmpresa datosEmpresa) {
        this.datosEmpresa = datosEmpresa;
    }

    public BigDecimal getRevenuesCagr10y() {
        return revenuesCagr10y;
    }

    public void setRevenuesCagr10y(BigDecimal revenuesCagr10y) {
        this.revenuesCagr10y = revenuesCagr10y;
    }

    public BigDecimal getRevenuesCagr5y() {
        return revenuesCagr5y;
    }

    public void setRevenuesCagr5y(BigDecimal revenuesCagr5y) {
        this.revenuesCagr5y = revenuesCagr5y;
    }

    public BigDecimal getCashflowCagr10y() {
        return cashflowCagr10y;
    }

    public void setCashflowCagr10y(BigDecimal cashflowCagr10y) {
        this.cashflowCagr10y = cashflowCagr10y;
    }

    public BigDecimal getCashflowCagr5y() {
        return cashflowCagr5y;
    }

    public void setCashflowCagr5y(BigDecimal cashflowCagr5y) {
        this.cashflowCagr5y = cashflowCagr5y;
    }

    public BigDecimal getEpsCagr10y() {
        return epsCagr10y;
    }

    public void setEpsCagr10y(BigDecimal epsCagr10y) {
        this.epsCagr10y = epsCagr10y;
    }

    public BigDecimal getEpsCagr5y() {
        return epsCagr5y;
    }

    public void setEpsCagr5y(BigDecimal epsCagr5y) {
        this.epsCagr5y = epsCagr5y;
    }

    public BigDecimal getEquityCagr5y() {
        return equityCagr5y;
    }

    public void setEquityCagr5y(BigDecimal equityCagr5y) {
        this.equityCagr5y = equityCagr5y;
    }

    public BigDecimal getDividendsCagr10y() {
        return dividendsCagr10y;
    }

    public void setDividendsCagr10y(BigDecimal dividendsCagr10y) {
        this.dividendsCagr10y = dividendsCagr10y;
    }

    public BigDecimal getDividendsCagr5y() {
        return dividendsCagr5y;
    }

    public void setDividendsCagr5y(BigDecimal dividendsCagr5y) {
        this.dividendsCagr5y = dividendsCagr5y;
    }
}
