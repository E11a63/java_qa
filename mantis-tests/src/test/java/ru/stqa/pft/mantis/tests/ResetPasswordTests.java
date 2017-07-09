package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ResetPasswordTests extends TestsBase {


  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void ResetPassword() throws IOException, MessagingException {

    app.login().userLogin("administrator", "root");
    String user = "user1";
    app.resetPassword().reset(user);
    String password = "password";

    List<MailMessage> mailMessages = app.mail().waitForMail(4, 10000);
    String email = app.resetPassword().email;
    String confirmationLink = findConfirmationLink(mailMessages, email);
    app.registration().finish(confirmationLink, password);
    assertTrue(app.newSession().login(user, password));

  }

  private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }
}

//  @AfterMethod(alwaysRun = true)
//  public void stopMailServer() {
//    app.mail().stop();
//  }
//}
