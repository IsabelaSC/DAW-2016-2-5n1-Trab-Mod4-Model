package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livro;
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
public class TestePersistirLivro {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirLivro() {
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
            
            //LivroBasico lb = em.find(LivroBasico.class, 4);            
            Livro l = new Livro();
            l.setIsbn("GREEN4");
            l.setTitulo("TWD");
            l.setEditora("FOX");
            l.setResumo("Apocalipse zumbi");
            l.setDataPublicacao(new GregorianCalendar(2006, Calendar.MARCH, 10));            
            l.setCodigoBarras("10000");
            l.setNumeroPaginas(200);
            l.setAtivo(true);
            l.setDataCadastro(new GregorianCalendar(2016, Calendar.FEBRUARY, 20));
            l.setValor(99.00);
            l.setIdioma(em.find(Idioma.class, 5));
            l.setFormato(em.find(Formato.class, 4));
            l.setCatalogo(em.find(Catalogo.class, 3));
            em.getTransaction().begin();
            em.persist(l);
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
