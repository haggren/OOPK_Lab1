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
public class FysikerDemo {
       public static void main(String[] args) {
        Fysiker numberOne = new Fysiker(25,"Achilles",2013);
        Human numberTwo = new Human(22,"Johan");
                
       System.out.println(numberOne.compareTo(numberTwo));
    }  
}

