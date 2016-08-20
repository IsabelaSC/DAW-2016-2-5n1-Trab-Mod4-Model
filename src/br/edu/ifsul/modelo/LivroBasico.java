package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Isabela
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED) //cada um tem sua tabela
@Table
public class LivroBasico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String isbn; //string ñ utiliza sequence generator 
    @Length(max = 40, message = "O titulo não pode ter mais que {max} caracteres.")
    @NotNull(message = "O titulo não deve ser nulo.")
    @NotBlank(message = "O titulo não pode ser em branco.")
    @Column(name = "nome", nullable = false, length = 40)
    private String titulo;
    @Column(name = "resumo", columnDefinition = "text")
    private String resumo;
    @Length(max = 40, message = "A editora não pode ter mais que {max} caracteres.")
    @NotNull(message = "A editora não deve ser nulo.")
    @NotBlank(message = "A editora não pode ficar em branco.")
    @Column(name = "nome", nullable = false, length = 40)
    private String editora;
    @NotNull(message = "A data de publicação deve ser informada.")
    @Temporal(TemporalType.DATE)
    @Column(name = "dataPublicacao", nullable = false)
    private Calendar dataPublicacao;

    public LivroBasico() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.isbn);
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
        final LivroBasico other = (LivroBasico) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        return true;
    }

}
