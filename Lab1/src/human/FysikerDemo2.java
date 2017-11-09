/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package human;
import java.util.Arrays;
/**
 *
 * @author hugo
 */
public class FysikerDemo2 {
    public static void main(String[] args) {
        
       Fysiker[] fysikerList = new Fysiker[15];
       for (int i=0; i<15; i++){
            int count = 0;
            int maxTries=20;
               
            while (count <= maxTries){
                try {
       
                    fysikerList[i]=new Fysiker();
                
                    }
                catch(IllegalArgumentException e) {
                    count++;
                    }
                }
       }
       Arrays.sort(fysikerList);
       for (Fysiker fysikerList1 : fysikerList) {
            System.out.println(fysikerList1);
        }
     } 
}
