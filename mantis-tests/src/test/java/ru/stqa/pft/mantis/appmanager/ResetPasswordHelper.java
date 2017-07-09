package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created on 08.07.2017.
 */
public class ResetPasswordHelper extends HelperBase {
  public ResetPasswordHelper(ApplicationManager app) {
    super(app);
  }

  public String email() {
    return email;
  }

  public static void setEmail(String email) {
    ResetPasswordHelper.email = email;
  }

  public static String email;

  public void reset(String username) {
    wd.get(app.getProperty("web.baseUrl") + "/manage_proj_create_page.php");
    wd.findElement(By.linkText("Manage Users")).click();
    wd.findElement(By.linkText(username)).click();
    email = wd.findElement(By.name("email")).getAttribute("value");;
    wd.findElement(By.xpath("//div[4]/form[1]/input[3]")).click();
  }

}
