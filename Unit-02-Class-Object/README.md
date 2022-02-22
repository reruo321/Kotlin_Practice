# Class & Object
Kotlin has some unique types of class and object.

## Data Class
We often create classes to mainly hold data. We have done it in Java like this:

public class Animal{
  private int legnum;
  // Getter
  public int getLegNumber(){
    return legnum;
  }
  // Setter
  public void setLegNumber(int n){
    this.legnum = n;
  }
}

While the getter method returns the value of the attribute, the setter assigns the value of a parameter to the attribute.

**Data Class**
