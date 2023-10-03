// File A.java
public class A {
public A(int value) {
System.out.println("Value is " + value);
}
}
// File B.java
public class B extends A {
public static void main (String[] args) {
A a = new A(10);
}
}