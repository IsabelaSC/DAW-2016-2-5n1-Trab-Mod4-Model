package br.edu.ifsul.testes.junit;

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
public class TestePersistirLivraria {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirLivraria() {
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
            Livraria l = new Livraria();
            l.setNome("Saraiva");
            l.setSite("www.saraiva.com.br");
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
