package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "livroBasico")
public class LivroBasico implements Serializable {

    @Id
    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn; //string ñ utiliza sequence generator     
    @Length(max = 40, message = "O titulo não pode ter mais que {max} caracteres.")
    @NotNull(message = "O titulo não deve ser nulo.")
    @NotBlank(message = "O titulo não pode ser em branco.")
    @Column(name = "titulo", nullable = false, length = 40)
    private String titulo;
    @Column(name = "resumo", columnDefinition = "text")
    private String resumo;
    @Length(max = 40, message = "A editora não pode ter mais que {max} caracteres.")
    @NotNull(message = "A editora não deve ser nulo.")
    @NotBlank(message = "A editora não pode ficar em branco.")
    @Column(name = "editora", nullable = false, length = 40)
    private String editora;
    @NotNull(message = "A data de publicação deve ser informada.")
    @Temporal(TemporalType.DATE)
    @Column(name = "dataPublicacao", nullable = false)
    private Calendar dataPublicacao;
    @ManyToMany
    @JoinTable(name = "autoria",
            joinColumns
            = @JoinColumn(name = "livroBasico", referencedColumnName = "isbn",
                    nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "autor", referencedColumnName = "id",
                    nullable = false))
    private List<Autor> autorias = new ArrayList<>();

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
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.isbn);
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

    public List<Autor> getAutorias() {
        return autorias;
    }

    public void setAutorias(List<Autor> autorias) {
        this.autorias = autorias;
    }

}
