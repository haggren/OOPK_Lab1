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
public class HumansAndFysiker {
     public static void main(String[] args) {
       
         
       Human[] fysikerAndHumanList = new Human[10];
       for (int i=0; i<5; i++){
            int count = 0;
            int maxTries=15;
               
            while (count <= maxTries){
                try {
       
                    fysikerAndHumanList[i]=new Fysiker();
                
                    }
                catch(IllegalArgumentException e) {
                    count++;
                    }
                }
       }
       for (int i=5; i<10; i++){
                fysikerAndHumanList[i]=new Human();
                
            }     
       for (Human i : fysikerAndHumanList) {
            System.out.println(i);
        }             
        } 
}

