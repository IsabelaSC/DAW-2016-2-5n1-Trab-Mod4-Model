package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Catalogo;
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
public class TestePersistirAntesCatalogo {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirAntesCatalogo() {
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
            Catalogo c = new Catalogo();
            c.setNome("Fixo");
            c.setDescricao("Apenas para consultas locais.");
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        //compara o resultado esperado (falso)com o que ocorreu
        Assert.assertEquals(false, exception);
    }

}
