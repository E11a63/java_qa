package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactsData;

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
  @Parameter(names = "-c", description = "contact count")
  int count;
  @Parameter(names = "-f", description = "Target file")
  String file;
  @Parameter(names = "-d", description = "Data format")
  String format;

  public static void main(String... args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();

    JCommander jc = JCommander.newBuilder()
            .addObject(generator)
            .build();
    try {
      jc.parse(args);
    } catch (ParameterException ex) {
      jc.usage();
      return;
    }
    generator.run();
  }


  private static List<ContactsData> generateContacts(int count) {
    List<ContactsData> contacts = new ArrayList<ContactsData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactsData().withFirstName(String.format("Генератор %s", i))
              .withLname(String.format("Генераторов %s", i))/*.withMname(String.format("Генераторович %s", i))*/.withGroup("name")
              .withPhoto(new File("src/test/resources/kat.jpg")));

    }
    return contacts;
  }

  private static void saveAsCsv(List<ContactsData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactsData contact : contacts) {
      writer.write(String.format("%s;%s;%s;%s\n", contact.getName(), contact.getLname(),/* contact.getMname(),*/contact.getGroup(), contact.getPhoto()));
    }
    writer.close();
  }

  public void run() throws IOException {

    List<ContactsData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json"))
      saveAsJson(contacts, new File(file));
    else {
      System.out.println("Unrecognized format " + format);
    }
  }

  private void saveAsXml(List<ContactsData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactsData.class);
    String xml = xstream.toXML(contacts);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }

  private void saveAsJson(List<ContactsData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }
}



