package ru.stqa.pft.task1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
  @Test
  public void testArea() {
    Point p1 = new Point(5, 10);
    Point p2 = new Point(4,10);
    Assert.assertEquals(p1.distance(p2), 1.0);
  }

  @Test
  public void testArea2() {
    Point p1 = new Point(5.0, 10.0);
    Assert.assertEquals(p1.distance(p1), 0.0);
  }
}
