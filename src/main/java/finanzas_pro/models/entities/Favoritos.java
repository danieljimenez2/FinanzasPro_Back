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
    @Column(name = "companySymbol")
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


}
