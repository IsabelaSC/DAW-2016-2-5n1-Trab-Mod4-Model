package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Isabela
 */
@Entity
@Table(name = "catalogo")
public class Catalogo implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_catalogo", sequenceName = "seq_catalogo_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_catalogo", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 40, message = "O nome não pode ter mais de {max} caracteres.")
    @NotNull(message = "O nome não pode ser nulo.")
    @NotBlank(message = "O nome não pode ser em branco.")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    @Length(max = 50, message = "O descricao não pode ter mais de {max} caracteres.")
    @NotNull(message = "A descrição não pode ser nula.")
    @NotBlank(message = "A descrição não pode ficar em branco.")
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;

    @NotNull(message = "A livraria não pode ser nula.")
    @ManyToOne
    @JoinColumn(name = "livraria_id", referencedColumnName = "id", nullable = false)
    private Livraria livraria;

    @OneToMany(mappedBy = "catalogo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro obj) {
        obj.setCatalogo(this);
        this.livros.add(obj); //adicionando telefone na lista
    }

    public void removerLivro(int index) {
        this.livros.remove(index);//p/ remover o telefone passa o indice pois ñ possui id
    }

    public Catalogo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Catalogo other = (Catalogo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Livraria getLivraria() {
        return livraria;
    }

    public void setLivraria(Livraria livraria) {
        this.livraria = livraria;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

}
