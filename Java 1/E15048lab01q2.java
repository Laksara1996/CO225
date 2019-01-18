import java.lang.*;
import java.util.Scanner;

public class E15048lab01q2 {

    public static void main(String[] args) {

        //Getting input

        System.out.print("Enter the color: ");

        Scanner keyboard = new Scanner(System.in);

        int red = keyboard.nextInt();
        int green = keyboard.nextInt();
        int blue = keyboard.nextInt();

        //Checking whether the colour inputs are within the range

        if(red>255){
            System.out.println("Enter the values of red in the range 0 and 255");
            System.exit(0);
        }
        if(green>255){
            System.out.println("Enter the values of green in the range 0 and 255");
            System.exit(0);
        }
        if(blue>255){
            System.out.println("Enter the values of blue in the range 0 and 255");
            System.exit(0);
        }

        //Converting each colour to its complement

        int red_Complement = 255 - red;
        int green_Complement = 255 - green;
        int blue_Complement = 255 - blue;

        // Checking whether complement dier by 32 or less and assigning correspondingly

        if((Math.abs(red - red_Complement)<=32)&&(Math.abs(green - green_Complement)<=32)&&(Math.abs(blue - blue_Complement)<=32)){
            if(red_Complement>128){
                red_Complement = red + 128;
            }else{
                red_Complement = red - 128;
            }
            if(green_Complement>128){
                green_Complement = green + 128;
            }else{
                green_Complement = green - 128;
            }
            if(blue_Complement>128){
                blue_Complement = blue + 128;
            }else{
                blue_Complement = blue - 128;
            }
        }

        // Giving output

        System.out.println("The complment: " + red_Complement+ " " + green_Complement + " " + blue_Complement);
    }
}
