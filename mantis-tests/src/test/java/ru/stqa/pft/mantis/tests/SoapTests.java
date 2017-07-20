package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.Issue;
import ru.stqa.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Created on 09.07.2017.
 */
public class SoapTests extends TestsBase {
  @BeforeTest
  
  @Test
  public void testGetProjects() throws RemoteException, ServiceException, MalformedURLException {
    Set<Project> projects = app.soap().getProjects();
    System.out.println(projects.size());
    for (Project project : projects) {
      System.out.println(project.getName());
    }
  }
  @Test
  public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
    Set<Project> projects = app.soap().getProjects();
    Issue issue = new Issue().withSummary("testIssue")
            .withDescription("testIssueDEscription").withProject(projects.iterator().next());
    Issue created = app.soap().addIssue(issue);
    assertEquals(issue.getSummary(),created.getSummary());

  }
}
