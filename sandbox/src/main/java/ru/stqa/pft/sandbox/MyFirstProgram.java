package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Alexei");

    Square s = new Square(5);
    System.out.println( "Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area ());

    Rectangle n = new Rectangle(5, 8);
    System.out.println("Площадь прямоугольника со сторонами " + n.a + " и " + n.b + " = " + n.area ());
  }
public static void hello(String somebody ){

  System.out.println("Hello, " + somebody + "!");
}

}