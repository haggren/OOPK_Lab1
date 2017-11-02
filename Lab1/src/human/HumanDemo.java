/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package human;
/**
 *
 * @author hugo
 */
public class HumanDemo {
       public static void main(String[] args) {
        Human numberOne = new Human(25,"Achilles");
        System.out.println(numberOne.getAge());
        System.out.println(numberOne.getName());
        System.out.println(numberOne);
    }  
}
