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
public class Human implements Comparable<Human> {
    /**
     * @param args the command line arguments
     */
   
    
    private int age; 
    private String name;
    private static String[] names = {"Adam", "Bertil", "Cesar", "David", "Erik", "Filip", "Gustav","Helge","Ivar","Johan"};
    
    public Human(int ageIn, String nameIn){
        age = ageIn;
        name = nameIn;
    }
    public Human(){
        this((int)(Math.random()*100),getRandomName());
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
         return ("Name:" + name + " Age:" + age);
    }
    public static String getRandomName(){
        return names[(int)(Math.random()*(names.length-1))];
    }
    @Override
    public int compareTo(Human testHuman){
        return ((Integer)this.age).compareTo(testHuman.getAge());
        
    }

}
