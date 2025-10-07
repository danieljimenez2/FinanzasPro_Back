package finanzas_pro.models.entities;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "precio_y_datos_generales")
public class PrecioYDatosGenerales {


    @Id
    @Column(name = "company_symbol", length = 50, nullable = false)
    private String companySymbol;

    @OneToOne
    @MapsId
    @JoinColumn(name = "company_symbol")
    private DatosEmpresa datosEmpresa;

    @Column(name = "Precio", precision = 36, scale = 16)
    private BigDecimal precio;

    @Column(name = "min52s_max52s", precision = 36, scale = 16)
    private BigDecimal min52sMax52s;

    @Column(name = "Beta", precision = 36, scale = 16)
    private BigDecimal beta;

    @Column(name = "per_ttm", precision = 36, scale = 16)
    private BigDecimal perTtm;

    @Column(name = "tamaño_mercado", columnDefinition = "ENUM('BIG CAP','MICRO CAP','MID CAP','SMALL CAP')")
    private String tamanoMercado;

    @Column(name = "market_cap")
    private Long marketCap;

    @Column(name = "valor_empresa")
    private Long valorEmpresa;

    @Column(name = "situacion_caja", columnDefinition = "ENUM('CAJA NETA','DEUDA NETA')")
    private String situacionCaja;

    @Column(name = "ultimo_dividendo", precision = 36, scale = 16)
    private BigDecimal ultimoDividendo;

    @Column(name = "Rango 52S", columnDefinition = "TEXT")
    private String rango52s;

    @Column(name = "minimo_52s", precision = 36, scale = 16)
    private BigDecimal minimo52s;

    @Column(name = "maximo_52s", precision = 36, scale = 16)
    private BigDecimal maximo52s;

    public String getTamanoMercado() {
        return tamanoMercado;
    }

    public void setTamanoMercado(String tamanoMercado) {
        this.tamanoMercado = tamanoMercado;
    }

    public void setSituacionCaja(String situacionCaja) {
        this.situacionCaja = situacionCaja;
    }

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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getMin52sMax52s() {
        return min52sMax52s;
    }

    public void setMin52sMax52s(BigDecimal min52sMax52s) {
        this.min52sMax52s = min52sMax52s;
    }

    public BigDecimal getBeta() {
        return beta;
    }

    public void setBeta(BigDecimal beta) {
        this.beta = beta;
    }

    public BigDecimal getPerTtm() {
        return perTtm;
    }

    public void setPerTtm(BigDecimal perTtm) {
        this.perTtm = perTtm;
    }


    public Long getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    public Long getValorEmpresa() {
        return valorEmpresa;
    }

    public void setValorEmpresa(Long valorEmpresa) {
        this.valorEmpresa = valorEmpresa;
    }


    public String getSituacionCaja() {
        return situacionCaja;
    }

    public BigDecimal getUltimoDividendo() {
        return ultimoDividendo;
    }

    public void setUltimoDividendo(BigDecimal ultimoDividendo) {
        this.ultimoDividendo = ultimoDividendo;
    }

    public String getRango52s() {
        return rango52s;
    }

    public void setRango52s(String rango52s) {
        this.rango52s = rango52s;
    }

    public BigDecimal getMinimo52s() {
        return minimo52s;
    }

    public void setMinimo52s(BigDecimal minimo52s) {
        this.minimo52s = minimo52s;
    }

    public BigDecimal getMaximo52s() {
        return maximo52s;
    }

    public void setMaximo52s(BigDecimal maximo52s) {
        this.maximo52s = maximo52s;
    }
}
