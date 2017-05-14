package ru.stqa.pft.task1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
  @Test
  public void testArea() {
    Point p1 = new Point(5, 10, 4, 10);
    Assert.assertEquals(p1.metodx(), 1.0);
  }

  @Test
  public void testArea2() {
    Point p1 = new Point(5.0, 10.0, 4.0, 10.0);
    Assert.assertEquals(p1.metodx(), 1.0);
  }
}
