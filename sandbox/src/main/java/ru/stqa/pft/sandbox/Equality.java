package ru.stqa.pft.sandbox;

/**
 * Created on 27.05.2017.
 */
public class Equality {
  public static void main(String[] args) {
    String s1= "Firefox";
    String s2 = "Fire" + "fox";
    System.out.println(s1==s2);
    System.out.println(s1.equals(s2));
  }
}
