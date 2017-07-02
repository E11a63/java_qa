package ru.stqa.pft.addressbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;


/**
 * Created on 22.06.2017.
 */
public class HbConnectionTest {
  private SessionFactory sessionFactory;

  @BeforeClass
  protected void setUp() throws Exception {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
    try {
      sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    } catch (Exception e) {
      e.printStackTrace();

      StandardServiceRegistryBuilder.destroy(registry);
    }
  }

  @Test(enabled = false)
  public void testHbConnection() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery("from GroupData" ).list();
    for (GroupData group : result) {
      System.out.println(group);
    }
    session.getTransaction().commit();
    session.close();


  }
  @Test
  public void testHbConnectionContact() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactsData> result = session.createQuery("from ContactsData where deprecated='0000-00-00'").list();
    session.getTransaction().commit();
    session.close();
    for (ContactsData contact : result) {
      System.out.println(contact);
      System.out.println(contact.getGroups());
    }
  }
  @Test
  public void testHbConnectionGroup() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery("from GroupData" ).list();
    session.getTransaction().commit();
    session.close();
    for (GroupData group : result) {
      System.out.println(group);
      System.out.println(group.getContacts());
    }

  }
}
