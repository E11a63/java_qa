package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.ContactsData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 17.06.2017.
 */
public class ContactDataGenerator {
  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactsData> contacts = generateContacts(count);
    save(contacts, file);
  }


  private static List<ContactsData> generateContacts(int count) {
    List<ContactsData> contacts = new ArrayList<ContactsData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactsData().withFirstName(String.format("Генератор %s", i))
              .withLname(String.format("Генераторов %s", i)).withMname(String.format("Генераторович %s", i)));

    }
    return contacts;
  }

  private static void save(List<ContactsData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactsData contact : contacts) {
      writer.write(String.format("%s;%s;%s\n", contact.getName(), contact.getLname(), contact.getMname()));
    }
    writer.close();
  }
}


