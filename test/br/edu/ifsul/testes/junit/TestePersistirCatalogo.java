package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livraria;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Isabela
 */
public class TestePersistirCatalogo {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirCatalogo() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-2016-2-5n1-Trab-Mod4-ModelPU");
        em = emf.createEntityManager();

    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {
            //teste sem associação c/ livraria
            Catalogo c = new Catalogo();
//            c.setNome("PORTFOLIO");
//            c.setDescricao("resumidos");
//------------*----------------*-------------*----------  
            //teste com associação de livraria
            c.setNome("MINI");
            c.setDescricao("Letrinhas");
            Livraria l = em.find(Livraria.class, 7);          
            l.adicionarCatalogo(c);
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        //compara o resultado esperado (falso)com o que ocorreu
        Assert.assertEquals(false, exception);

    }

}
