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
public class E5{ 
           public static void main(String[] args) {
               Human a = new Human();
               Human b = new Human();
               
               if (a.compareTo(b) == 1){
                   System.out.println(b.getName() + ", som är "+b.getAge() + " är yngre än " + a.getName() +", som är " + a.getAge());
               }
               else if(a.compareTo(b) == -1){
                   System.out.println(a.getName() + ", som är "+a.getAge() + " är yngre än " + b.getName() +", som är " + b.getAge());
                  
               }
               else{
                   System.out.println(a.getName() + ", som är "+a.getAge() + " är lika gammal som " + b.getName() +", som är " + b.getAge());
               }
           }
}
