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
public class Fysiker extends Human{
    
    private int year;
    
    public Fysiker(int ageIn, String nameIn, int yearIn){
            super(ageChecker(ageIn,yearIn),nameIn);
            year=yearChecker(yearIn);
           
                    }
    public Fysiker(){
        this((int)(Math.random()*100),getRandomName(),1932 + (int)(Math.random()*(2015-1932)) );
    }
    public static int ageChecker(int x, int y){
            if ((x - 2017 + y) < 15){
               throw new IllegalArgumentException("Får ej vara yngre än 15 vid startår.");
            }
            else {
                return x;
            }
    }
     public int yearChecker(int y){
            if (1932<y && y<2015){
                return y;
            }
            else {
                throw new IllegalArgumentException("Årgång måste vara mellan 1932-2015");
            }
    }
    public int getYear(){
        return year;
    }
    public String toString(){
        return ("Name:" + getName() + " Age:" + getAge() + " Årgång:" + getYear());
    }
 }

