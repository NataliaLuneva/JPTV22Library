/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tooks;

import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class InputFromKeyboard {

    public static int importNumberFromRange(Integer min, Integer max) {
        Scanner scanner = new Scanner(System.in);
        int number = min - 1;
        boolean isNumber = true;
        boolean repeat;
        do{
            try{
                number = scanner.nextInt();
                scanner.nextLine();
            
            } catch (Exception e) {
                scanner.nextLine();
                isNumber = false;
            }
            if(max == null ){
                if((number >= min) && isNumber){
                repeat = false;
                }else{
                    System.out.printf("Enter number from next range: %d.. %d:", 
                            min, max);
                    isNumber = true;
                    repeat = true;
                }
            }else{
                if((number >= min && number <= max)&& isNumber){
                    repeat = false;
                }else{
                    System.out.printf("Enter number from next range: %d.. %d:", 
                            min, max);
                    isNumber = true;
                    repeat = true;
                }
                
        }
        }while(repeat);
        return number;
    }
    
}
