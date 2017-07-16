package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Square;


/**
 * Created by Dmitrij on 14.05.2017.
 */
public class SquareTests {
  @Test
public void testArea () {
  Square s = new Square(5);
  Assert.assertEquals(s.area () ,20.0);
}

}
