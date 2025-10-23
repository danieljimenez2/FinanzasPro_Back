package finanzas_pro.models.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "favoritos")
public class Favoritos {

    @Id
    @Column(name = "company_symbol")
    private String companySymbol;

    @Column(name = "CompanyName")
    private String companyName;

    @Column(name = "per_ttm", precision = 36, scale = 16)
    private BigDecimal perTtm;

    @Column(name = "situacion_caja")
    private String situacionCaja;

    @Column(name = "ev_fcf", precision = 36, scale = 16)
    private BigDecimal evFcf;

    @Column(name = "roce", precision = 36, scale = 16)
    private BigDecimal roce;

    @Column(name = "ratio_deuda", precision = 36, scale = 16)
    private BigDecimal ratioDeuda;

    @Column(name = "liquidez", precision = 36, scale = 16)
    private BigDecimal liquidez;

    @Column(name = "margen_bruto", precision = 36, scale = 16)
    private BigDecimal margenBruto;

    @Column(name = "margen_neto", precision = 36, scale = 16)
    private BigDecimal margenNeto;

    @Column(name = "dividend_yield_ttm", precision = 36, scale = 16)
    private BigDecimal dividendYieldTtm;

    @Column(name = "payoutRatioTtm", precision = 36, scale = 16)
    private BigDecimal payoutRatioTtm;


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

    public BigDecimal getPerTtm() {
        return perTtm;
    }

    public void setPerTtm(BigDecimal perTtm) {
        this.perTtm = perTtm;
    }

    public String getSituacionCaja() {
        return situacionCaja;
    }

    public void setSituacionCaja(String situacionCaja) {
        this.situacionCaja = situacionCaja;
    }

    public BigDecimal getEvFcf() {
        return evFcf;
    }

    public void setEvFcf(BigDecimal evFcf) {
        this.evFcf = evFcf;
    }

    public BigDecimal getRoce() {
        return roce;
    }

    public void setRoce(BigDecimal roce) {
        this.roce = roce;
    }

    public BigDecimal getRatioDeuda() {
        return ratioDeuda;
    }

    public void setRatioDeuda(BigDecimal ratioDeuda) {
        this.ratioDeuda = ratioDeuda;
    }

    public BigDecimal getLiquidez() {
        return liquidez;
    }

    public void setLiquidez(BigDecimal liquidez) {
        this.liquidez = liquidez;
    }

    public BigDecimal getMargenBruto() {
        return margenBruto;
    }

    public void setMargenBruto(BigDecimal margenBruto) {
        this.margenBruto = margenBruto;
    }

    public BigDecimal getMargenNeto() {
        return margenNeto;
    }

    public void setMargenNeto(BigDecimal margenNeto) {
        this.margenNeto = margenNeto;
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
