package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Isabela
 */
@Entity
@Table(name = "livro")
public class Livro extends LivroBasico implements Serializable {

    @Length(max = 40, message = "O codigo de barras não pode ter mais que {max} caracteres.")
    @NotNull(message = "O codigo de barras não deve ser nulo.")
    @NotBlank(message = "O codigo de barras não pode ser em branco.")
    @Column(name = "codigoBarras", nullable = false, length = 40)
    private String codigoBarras;
    @NotNull(message = "O numero de paginas não deve ser nulo.")
    @Column(name = "numeroPaginas", nullable = false, length = 5)
    private Integer numeroPaginas;
    @NotNull(message = "Ativo não pode ser nulo")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    @NotNull(message = "A data de cadastro deve ser informada.")
    @Temporal(TemporalType.DATE)
    @Column(name = "dataCadastro", nullable = false)
    private Calendar dataCadastro;
    @NotNull(message = "O valor não pode ser nulo.")
    @Min(value = 0, message = "O valor não pode ser negativo.")
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valor;
    @NotNull(message = "O idioma não pode ser nulo.")
    @ManyToOne
    @JoinColumn(name = "idioma_id", referencedColumnName = "id", nullable = false)
    private Idioma idioma;
    @NotNull(message = "O formato não pode ser nulo.")
    @ManyToOne
    @JoinColumn(name = "formato_id", referencedColumnName = "id", nullable = false)
    private Formato formato;
    @NotNull(message = "O catalogo não pode ser nulo.")
    @ManyToOne
    @JoinColumn(name = "catalogo_id", referencedColumnName = "id", nullable = false)
    private Catalogo catalogo;

    public Livro() {
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.codigoBarras);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livro other = (Livro) obj;
        if (!Objects.equals(this.codigoBarras, other.codigoBarras)) {
            return false;
        }
        return true;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }
}
