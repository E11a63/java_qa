package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ResetPasswordTests extends TestsBase {


  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void ResetPassword() throws IOException, MessagingException, SQLException {

    app.login().userLogin("administrator", "root");
    String user=app.db().getUserName();
    app.registration().reset(user);
    String password = "password";

    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String email = app.registration().email;
    String confirmationLink = app.registration().findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, password);
    assertTrue(app.newSession().login(user, password));
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }

}
