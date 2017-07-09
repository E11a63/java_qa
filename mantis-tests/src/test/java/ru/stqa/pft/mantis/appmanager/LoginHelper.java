package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created on 08.07.2017.
 */
public class LoginHelper extends HelperBase {
  public LoginHelper(ApplicationManager app) {
    super(app);

  }

  public void userLogin(String login, String password) {
    wd.get(app.getProperty("web.baseUrl"));
    type(By.name("username"), login);
    type(By.name("password"), password);
    click(By.cssSelector("input.button"));

  }
}
