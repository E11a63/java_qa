package ru.stqa.pft.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

/**
 * Created on 24.06.2017.
 */
public class DbHelper {
  private final SessionFactory sessionFactory;

  public DbHelper() {


    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

  }

  public Groups groups() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery("from GroupData").list();
    session.close();
    return new Groups(result);
  }

  public Contacts contacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactsData> result = session.createQuery("from ContactsData where deprecated='0000-00-00'")
            .list();
    session.close();
    return new Contacts(result);
  }

  public ContactsData contactById(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    ContactsData result = (ContactsData) session.createQuery("from ContactsData where id=" + id+"and deprecated='0000-00-00'").uniqueResult();
    session.getTransaction().commit();
    session.close();
    return result;
  }
}
