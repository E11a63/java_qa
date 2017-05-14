package ru.stqa.pft.task1;


public class Point {
public double x;
public double y;
public double z;
public double w;



public Point (double x, double y, double z, double w) {
this.x = x;
this.y = y;
this.z = z;
this.w = w;

}
  public double metodx() {
    return Math.sqrt (((this.z - this.x)*(this.z - this.x))+((this.w-this.y)*(this.w-this.y)));
  }

}



