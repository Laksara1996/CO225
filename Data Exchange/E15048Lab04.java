
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class E15048Lab04 {

    public static void main(String[] args) {
        
        char [] array = args[0].toCharArray();
        //System.out.println(array[1]);

        String csvFile = "./contacts.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        int last = array.length - 2;
        int flag = 0;
        
        String name = new String(array, 2, last);
        
        if(array[0]=='F'){
        
            try {

                br = new BufferedReader(new FileReader(csvFile));

                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] tel = line.split(cvsSplitBy);
                                        
                    if(tel[0].equals(name)){
                    
                        System.out.println(tel[0]+ " " + tel[1]+ " tel: "+tel[2]);
                        flag = 1;
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("File cann't find.");
            } catch (IOException e) {
                System.out.println("Error");
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                    }
                }
            }
        
        }else if(array[0] == 'L'){
        
            try {

                br = new BufferedReader(new FileReader(csvFile));

                while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] tel = line.split(cvsSplitBy);
                                        
                    if(tel[1].equals(name)){
                    
                        System.out.println(tel[0]+ " " + tel[1]+ " tel: "+tel[2]);
                        flag = 1;
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("File cann't find.");
            } catch (IOException e) {
                System.out.println("Error");
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                    }
                }
            }
            
        }else{
        
            System.out.println("Invalid input data type.");
            
        }
        
        if(flag == 0){
            System.out.println("Name cannot be found in the database");
        }
    }
}