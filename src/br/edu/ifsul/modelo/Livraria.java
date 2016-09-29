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
@Table(name = "livraria")
public class Livraria implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_livraria", sequenceName = "seq_livraria_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_livraria", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 40, message = "O nome não pode ter mais de {max} caracteres.")
    @NotNull(message = "O nome não pode ser nulo.")
    @NotBlank(message = "O nome não pode ser em branco.")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    @Length(max = 20, message = "O site não pode ter mais de {max} caracteres.")
    @Column(name = "site", length = 20)
    private String site;
    @OneToMany(mappedBy = "livraria", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Catalogo> catalogos = new ArrayList<>();

    public Livraria() {
    }

    public void adicionarCatalogo(Catalogo obj) {
        obj.setLivraria(this);
        this.catalogos.add(obj); //adicionando telefone na lista
    }

    public void removerCatalogo(int index) {
        this.catalogos.remove(index);//p/ remover o catalogo passa o indice pois ñ possui id
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

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
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
        final Livraria other = (Livraria) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Catalogo> getCatalogos() {
        return catalogos;
    }

    public void setCatalogos(List<Catalogo> catalogos) {
        this.catalogos = catalogos;
    }

}
