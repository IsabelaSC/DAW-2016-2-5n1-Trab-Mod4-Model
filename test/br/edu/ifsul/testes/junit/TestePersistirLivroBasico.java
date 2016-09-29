package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.LivroBasico;
import com.sun.corba.se.spi.logging.CORBALogDomains;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class TestePersistirLivroBasico {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirLivroBasico() {
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
            LivroBasico lb = new LivroBasico();
            lb.setIsbn("WHAT");
            lb.setTitulo("TWD");
            lb.setEditora("FOX");
            lb.setResumo("Apocalipse zumbi");            
            lb.setDataPublicacao(new GregorianCalendar(2000, Calendar.MARCH,10));
            
            em.getTransaction().begin();
            em.persist(lb);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
            //System.out.println("Erro : "++); colocar no util  -- camada de modelo contem a utilização do erro.
        }
        //coma para o resultado esperado (falso)com o que ocorreu
        Assert.assertEquals(false, exception);

    }

}
