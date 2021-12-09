import java.util.*;
import java.time.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import model.*;

public class App {

    private static void test() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("demoDb");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        //Semesters
        Semester Spring2021 = new Semester("Spring2021", LocalDate.of(2021, 01, 19));
        Semester Fall2021 = new Semester("Fall2021", LocalDate.of(2021, 8, 17));
        Semester Spring2022 = new Semester("Spring2022", LocalDate.of(2022, 01, 20));
        
        //Departments
        Department cecs = new Department("Computer Engineering and Computer Science", "CECS" );
        Department ital = new Department("Italian Studies", "ITAL" );
        
        //Courses
        byte byteThree = 3;
        byte byteFour = (byte)4;
        Course cecs174 = new Course( "174", "Introduction to Programming and Problem Solving", byteThree );
        Course cecs274 = new Course( "274", "Data Structures", byteThree );
        Course cecs277 = new Course( "277", "Object Oriented Application Programming", byteThree );
        Course cecs282 = new Course( "282", "Advanced C++", byteThree );
        Course ital101A = new Course( "101", "Fundamentals of Italian", byteFour );
        Course ital101B = new Course( "101", "Fundamentals of Italian", byteFour );
        
        //Timeslots
        Timeslot mw = new Timeslot((byte) 0101000, LocalTime.of(12, 30), LocalTime.of(1, 45));
        Timeslot ts = new Timeslot((byte) 0010100, LocalTime.of(2, 0), LocalTime.of(3, 15));
        Timeslot mwf = new Timeslot((byte) 0101010, LocalTime.of(12, 0), LocalTime.of(12, 50));
        Timeslot f = new Timeslot((byte) 0000010, LocalTime.of(8, 0), LocalTime.of(10, 45));
        
        //Sections
        Section cecs174sec1 = new Section((byte)174, (short) 105, Spring2021, ts);
        Section cecs274sec1 = new Section((byte)274, (short) 140, Fall2021, ts);
        Section cecs277sec3 = new Section((byte)277, (short) 35, Fall2021, ts);
        Section cecs282sec5 = new Section((byte)282, (short) 35, Spring2022, ts);
        Section cecs277sec1 = new Section((byte)277, (short) 35, Spring2022, ts);
        Section cecs282sec7 = new Section((byte)282, (short) 35, Spring2022, ts);
        Section ital101Asec1 = new Section((byte)101, (short) 25, Spring2022, ts);
        
        //Students
        Student naomi = new Student("Naomi Nagata");
        Student james = new Student("James Holden");
        Student amos = new Student("Amos Burton");
        
        Transcript trans1 = new Transcript(naomi, cecs174sec1);
        trans1.setGradeEarned(" A");
        trans1.getStudent().getTranscripts().add(trans1);
        
        Transcript trans2 = new Transcript(naomi, cecs274sec1);
        trans2.setGradeEarned(" D");
        trans2.getStudent().getTranscripts().add(trans2);
        
        Transcript trans3 = new Transcript(naomi, cecs277sec3);
        trans3.setGradeEarned(" B");
        trans3.getStudent().getTranscripts().add(trans3);
        
        
        naomi.getGPA();

        em.persist(Spring2021);
        em.persist(Fall2021);
        em.persist(Spring2022);
        em.persist(cecs);
        em.persist(ital);
        em.persist(cecs174);
        em.persist(cecs274);
        em.persist(cecs277);
        em.persist(cecs282);
        em.persist(ital101A);
        em.persist(ital101B);
        em.persist(mw);
        em.persist(ts);
        em.persist(mwf);
        em.persist(f);
        em.persist(cecs174sec1);
        em.persist(cecs274sec1);
        em.persist(cecs277sec3);
        em.persist(cecs282sec5);
        em.persist(cecs277sec1);
        em.persist(cecs282sec7);
        em.persist(ital101Asec1);
        em.persist(naomi);
        em.persist(james);
        em.persist(amos);

        // Committing the transaction will push/"flush" the changes to the database.
        em.getTransaction().commit();
        System.out.println("Semester " + Spring2021 + " added to database. Go check DataGrip if you don't believe me!");
       

        return;
    }

    public static void main(String[] args) throws Exception {

        test();
    }
}