/*
 Rezolva urmatoarea problema intr-un limbaj de programare (la alegerea ta, dar codul sa fie 
 * compilabil/executabil, deci nu se accepta pseudocod): Se dau a) un numar intreg i si 
 * b) o colectie arbitrar de lunga (f1, f2, ..., fn) de functii care accepta ca argument
 * un numar intreg si intorc tot un numar intreg. Sa se scrie un program care intoarce
 * o colectie de numere intregi reprezentand rezultatele aplicarii acelor functii 
 * asupra valorii i. Exemplu de input: 4 si [add_one, multiply_by_five] => output-ul 
 * va fi [5, 20]. Alt exemplu de input: 7 si [subtract_three, add_two, multiply_by_three] => 
 * output-ul va fi [4, 9, 21]. Atentie: Nu da copy/paste la cod aici. Urca programul
 * tau pe GitHub si posteaza aici link-ul.
 */
package apl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Anna
 */
public class Apl {

    public static void main(String[] args) {
        try {
            System.out.print("Your number:");
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
            String firstinput = reader1.readLine();

            System.out.print("Type the operations (Eg. [add_3,multiplyby_6]):");
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
            String secondinput = reader2.readLine();

            String operations = secondinput.substring(1, secondinput.lastIndexOf("]"));
            String[] parts;

            //verificam inputul userului sa fie de formatul dorit printr-un regex
            if (secondinput.matches("\\[((add_|multiplyby_|substract_|divideby_)(\\d)+,{0,1})*\\]")) {
                
                String[] oneop = new String[1];
                
                if (operations.contains(",")) {     
                    parts = operations.split(",");
                    
                    for (int i = 0; i < parts.length; i++) {
                        String[] function = new String[parts.length];
                        String[] number = new String[parts.length];
                        
                        function[i] = parts[i].substring(0, parts[i].indexOf("_"));
                        number[i] = parts[i].substring(parts[i].indexOf("_")+ 1, parts[i].length());

                        if (function[i].equalsIgnoreCase("add")) {
                            System.out.print(Integer.parseInt(firstinput) + Integer.parseInt(number[i]) + " ");
                        }
                        if (function[i].equalsIgnoreCase("substract")) {
                            System.out.print(Integer.parseInt(firstinput) - Integer.parseInt(number[i]) + " ");
                        }
                        if (function[i].equalsIgnoreCase("multiplyby")) {
                            System.out.print(Integer.parseInt(firstinput) * Integer.parseInt(number[i]) + " ");
                        }
                        if (function[i].equalsIgnoreCase("divideby")) {
                            System.out.print(Integer.parseInt(firstinput) / Integer.parseInt(number[i]) + " ");
                        }
                    }
                } else {
                   
                    oneop = operations.split("_");
                    if (oneop[0].equalsIgnoreCase("add")) {
                        System.out.print(Integer.parseInt(firstinput) + Integer.parseInt(oneop[1]));
                    }
                    if (oneop[0].equalsIgnoreCase("substract")) {
                        System.out.print(Integer.parseInt(firstinput) - Integer.parseInt(oneop[1]));
                    }
                    if (oneop[0].equalsIgnoreCase("multiplyby")) {
                        System.out.print(Integer.parseInt(firstinput) * Integer.parseInt(oneop[1]));
                    }
                    if (oneop[0].equalsIgnoreCase("divideby")) {
                        System.out.print(Integer.parseInt(firstinput) / Integer.parseInt(oneop[1]));
                    }



                }
                //daca nu respecta pattern-ul
            } else {
                System.out.println("Please type again the operation desired (Eg. [add_3,multiplyby_6])");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
