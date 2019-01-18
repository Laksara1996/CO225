import java.util.Scanner;

public class E15048lab01q1 {

    public static void main(String[] args) {

        int special = 0,big = 0, weird = 0;

        Scanner keyboard = new Scanner (System.in);

        //Getting input

        System.out.print("Enter a number: ");

        int number = keyboard.nextInt();

        // Checking whether the inputs are special, big or weird and assigning values for each correspondingly.

        if (number % 15 == 0){
            special = 1;
        }
        if (number > 999){
            big = 1;
        }
        if ((number % 5 == 0) && (number % 6 == 0) && ((number % 18 != 0))){
            weird = 1;
        }

        // Giving output

        if((special ==1) && (big == 0) && (weird == 0)){
            System.out.println(number +" is special, but not scary.");
        }else if((special ==1) && (big == 1) && (weird == 0)){
            System.out.println(number +" is special, big, scary but not weird.");
        }else if((special ==1) && (big == 0) && (weird == 1)){
            System.out.println(number +" is special, weird, scary but not big.");
        }else if((special ==1) && (big == 1) && (weird == 1)){
            System.out.println(number +" is special, big, weird, scary.");
        }else if((special ==0) && (big == 1) && (weird == 0)){
            System.out.println(number +" is big, scary, but not weird.");
        }else if((special ==0) && (big == 1) && (weird == 1)){
            System.out.println(number +" is big, weird, scary, but not special.");
        }else if((special ==0) && (big == 0) && (weird == 1)){
            System.out.println(number +" is weird, scary, but not special, big.");
        }else{
            System.out.println(number +" is not special, weird, big or scary.");
        }
    }
}
