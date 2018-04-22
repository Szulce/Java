import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Map;

public class ConnectionToBase {

   private EntityManagerFactory entityManagerFactory;
   private EntityManager entityManager;

   ConnectionToBase()
   {
       entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
      entityManager = entityManagerFactory.createEntityManager();
   }

   public void close()
   {
      entityManager.close();

   }

   public void wstaw(String imie,String nazwisko,int premia)
   {
      Repository R = new Repository();
      R.setImie(imie);
      R.setNazwisko(nazwisko);
      R.setPremia(premia);
      entityManager.getTransaction().begin();
      entityManager.persist(R);
      entityManager.getTransaction().commit();
   }

   public void suma()
   {
      System.out.println(entityManager.createNativeQuery("SELECT SUM(PREMIAS) FROM PREMIE").getSingleResult());
   }
   public void usun(String imie, String nazwisko)
   {
      entityManager.getTransaction().begin();
      entityManager.createNativeQuery("DELETE FROM PREMIE WHERE IMIE = ? AND NAZWISKO= ?")
      .setParameter(1,imie)
      .setParameter(2,nazwisko).executeUpdate();
      entityManager.getTransaction().commit();
      /*
    Repository R = entityManager.find(Repository.class,id);
    try {
       entityManager.remove(R);
    }catch (IllegalArgumentException i)
    {
       //obsługa błedu
    }*/
   }
}
