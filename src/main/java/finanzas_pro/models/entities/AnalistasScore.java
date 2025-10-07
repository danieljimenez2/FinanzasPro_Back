package finanzas_pro.models.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "analistas_score")
public class AnalistasScore {


    @Id
    @Column(name = "company_symbol", length = 20, nullable = false)
    private String companySymbol;

    @OneToOne
    @MapsId
    @JoinColumn(name = "company_symbol")
    private DatosEmpresa datosEmpresa;

    @Column(name = "rating", length = 10)
    private String rating;

    @Column(name = "score")
    private Integer score;

    @Column(name = "recomendation", length = 255)
    private String recomendation;

    @Column(name = "Altman_score", precision = 30, scale = 14)
    private BigDecimal altmanScore;

    @Column(name = "piotroski_score")
    private Integer piotroskiScore;

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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRecomendation() {
        return recomendation;
    }

    public void setRecomendation(String recomendation) {
        this.recomendation = recomendation;
    }

    public BigDecimal getAltmanScore() {
        return altmanScore;
    }

    public void setAltmanScore(BigDecimal altmanScore) {
        this.altmanScore = altmanScore;
    }

    public Integer getPiotroskiScore() {
        return piotroskiScore;
    }

    public void setPiotroskiScore(Integer piotroskiScore) {
        this.piotroskiScore = piotroskiScore;
    }
}
