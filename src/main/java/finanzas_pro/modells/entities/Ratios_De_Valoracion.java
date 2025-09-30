package finanzas_pro.modells.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "ratios_de_valoracion")
public class Ratios_De_Valoracion {

    @Id
    @Column(name = "company_symbol", length = 50, nullable = false)
    private String companySymbol;

    @OneToOne
    @MapsId
    @JoinColumn(name = "company_symbol")
    private Datos_Empresa datosEmpresa;

    @Column(name = "pe_ttm", precision = 36, scale = 16)
    private BigDecimal peTtm;

    @Column(name = "precio_ventas", precision = 36, scale = 16)
    private BigDecimal precioVentas;
    
    @Column(name = "precio_fcf", precision = 36, scale = 16)
    private BigDecimal precioFcf;

    @Column(name = "precio_cash_flow", precision = 36, scale = 16)
    private BigDecimal precioCashFlow;

    @Column(name = "precio_valor_libros", precision = 36, scale = 16)
    private BigDecimal precioValorLibros;

    @Column(name = "peg_ratio_ttm", precision = 36, scale = 16)
    private BigDecimal pegRatioTtm;

    @Column(name = "ev_ventas", precision = 36, scale = 16)
    private BigDecimal evVentas;

    @Column(name = "ev_ebitda", precision = 65, scale = 16)
    private BigDecimal evEbitda;

    @Column(name = "ev_cfo", precision = 36, scale = 16)
    private BigDecimal evCfo;

    @Column(name = "ev_fcf", precision = 36, scale = 16)
    private BigDecimal evFcf;

    @Column(name = "porcentaje_beneficio", precision = 36, scale = 16)
    private BigDecimal porcentajeBeneficio;

    @Column(name = "porcentaje_fcf", precision = 36, scale = 16)
    private BigDecimal porcentajeFcf;

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

    public BigDecimal getPeTtm() {
        return peTtm;
    }

    public void setPeTtm(BigDecimal peTtm) {
        this.peTtm = peTtm;
    }

    public BigDecimal getPrecioVentas() {
        return precioVentas;
    }

    public void setPrecioVentas(BigDecimal precioVentas) {
        this.precioVentas = precioVentas;
    }

    public BigDecimal getPrecioFcf() {
        return precioFcf;
    }

    public void setPrecioFcf(BigDecimal precioFcf) {
        this.precioFcf = precioFcf;
    }

    public BigDecimal getPrecioCashFlow() {
        return precioCashFlow;
    }

    public void setPrecioCashFlow(BigDecimal precioCashFlow) {
        this.precioCashFlow = precioCashFlow;
    }

    public BigDecimal getPrecioValorLibros() {
        return precioValorLibros;
    }

    public void setPrecioValorLibros(BigDecimal precioValorLibros) {
        this.precioValorLibros = precioValorLibros;
    }

    public BigDecimal getPegRatioTtm() {
        return pegRatioTtm;
    }

    public void setPegRatioTtm(BigDecimal pegRatioTtm) {
        this.pegRatioTtm = pegRatioTtm;
    }

    public BigDecimal getEvVentas() {
        return evVentas;
    }

    public void setEvVentas(BigDecimal evVentas) {
        this.evVentas = evVentas;
    }

    public BigDecimal getEvEbitda() {
        return evEbitda;
    }

    public void setEvEbitda(BigDecimal evEbitda) {
        this.evEbitda = evEbitda;
    }

    public BigDecimal getEvCfo() {
        return evCfo;
    }

    public void setEvCfo(BigDecimal evCfo) {
        this.evCfo = evCfo;
    }

    public BigDecimal getEvFcf() {
        return evFcf;
    }

    public void setEvFcf(BigDecimal evFcf) {
        this.evFcf = evFcf;
    }

    public BigDecimal getPorcentajeBeneficio() {
        return porcentajeBeneficio;
    }

    public void setPorcentajeBeneficio(BigDecimal porcentajeBeneficio) {
        this.porcentajeBeneficio = porcentajeBeneficio;
    }

    public BigDecimal getPorcentajeFcf() {
        return porcentajeFcf;
    }

    public void setPorcentajeFcf(BigDecimal porcentajeFcf) {
        this.porcentajeFcf = porcentajeFcf;
    }
}
