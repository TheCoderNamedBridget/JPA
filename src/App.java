import java.util.*;
import java.time.*;
import jakarta.persistence.*;
import model.*;

public class App {

    private static void test() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("demoDb");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Semester Spring2021 = new Semester("Test", LocalDate.of(2021, 01, 19));

        em.persist(Spring2021);

        // Committing the transaction will push/"flush" the changes to the database.
        em.getTransaction().commit();
        System.out
                .println("Semester " + Spring2021 + " added to database. Go check DataGrip if you don't believe me!");

        return;
    }

    public static void main(String[] args) throws Exception {

        test();
    }
}
