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
public class Human {

    /**
     * @param args the command line arguments
     */
   

    private int age; 
    private String name;
    private static String[] names = {"Adam", "Bertil", "Cesar", "David", "Erik", "Filip", "Gustav","Helge","Ivar","Johan"};
    
    public Human(int ageIn, String nameIn){
        this.age = ageIn;
        this.name = nameIn;
    }
    public Human(){
        this((int)(Math.random()*100),names[(int)(Math.random()*(names.length-1))]);
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String toString() {
         return ("Name:" + name + " Age:" + age);
    }


}
