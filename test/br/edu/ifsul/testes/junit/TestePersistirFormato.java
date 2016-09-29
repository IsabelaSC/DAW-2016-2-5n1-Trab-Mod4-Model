package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Formato;
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
public class TestePersistirFormato {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirFormato() {
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
            Formato f = new Formato();
            f.setNome("Digital");                      
            em.getTransaction().begin();
            em.persist(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        //compara o resultado esperado (falso)com o que ocorreu
        Assert.assertEquals(false, exception);

    }

}
