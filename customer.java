import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class customer_opt{
    void display_menu(){
        try{
            File f = new File("menu.csv");
            Scanner r = new Scanner(f);
            System.out.println("----------------------------------------");
            System.out.println("                  Menu");
            System.out.println("----------------------------------------");
            int c = 1;

            while (r.hasNextLine()){
                String data = r.nextLine();
                String[] line = data.split(",");
                System.out.println(c + ". " + line[0] + "\n   Rs. " + line[1] + "\n");
                c++;
            }

            r.close();
        }

        catch (FileNotFoundException e){
            System.out.println("Something went wrong...");
        }
    }

    void feedback(){
        Scanner sc = new Scanner(System.in);

        System.out.print("How was your experience?\n> ");
        String fb = sc.nextLine();

        try{
            File f = new File("feedback.txt");

            if (!f.exists()){
                f.createNewFile();
            }

            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(fb);
            pw.close();
        }

        catch (IOException e){
            System.out.println("Something went wrong...");
        }
    }
}