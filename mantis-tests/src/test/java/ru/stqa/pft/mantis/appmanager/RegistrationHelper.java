package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import java.util.List;

/**
 * Created on 06.07.2017.
 */
public class RegistrationHelper extends HelperBase {

  public RegistrationHelper(ApplicationManager app) {
    super(app);
  }

  public void start(String username, String email) {
    wd.get(app.getProperty("web.baseUrl") + "/signup_page.php");
    type(By.name("username"),username);
    type(By.name("email"),email);
    click(By.cssSelector("input[value='Signup']"));
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    click(By.cssSelector("input[value='Update User']"));
  }
  public String email() {
    return email;
  }

  public static void setEmail(String email) {
    RegistrationHelper.email = email;
  }

  public static String email;

  public void reset(String username) {
    wd.get(app.getProperty("web.baseUrl") + "/manage_proj_create_page.php");
    wd.findElement(By.linkText("Manage Users")).click();
    wd.findElement(By.linkText(username)).click();
    email = wd.findElement(By.name("email")).getAttribute("value");;
    wd.findElement(By.xpath("//div[4]/form[1]/input[3]")).click();
  }
  public String findConfirmationLink(List<MailMessage> mailMessages, String email) {
    MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
    VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
    return regex.getText(mailMessage.text);
  }
}
