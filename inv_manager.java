import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class inv_opt{
    void add_trans(){
        Scanner sc = new Scanner(System.in);
        int flag = 1;

        try{
            File f = new File("inv_finance.csv");

            if(!f.exists()){
                f.createNewFile();
            }

            FileWriter fw = new FileWriter(f,true);
          	BufferedWriter bw = new BufferedWriter(fw);
          	PrintWriter pw = new PrintWriter(bw);

            while (flag == 1){
                System.out.print("\nEnter stock item name: ");
                String sti = sc.next();
                System.out.print("Enter stock item quantity: ");
                int stq = sc.nextInt();
                System.out.print("Enter stock item PPI: ");
                int stp = sc.nextInt();
                pw.println(sti + "," + stq + "," + (stp * stq));
                System.out.print("Do you want to continue (y/n): ");
                String con = sc.next();

                if (con.equals("n")){
                    flag = 0;
                }
            }

            pw.close();
        }

        catch (IOException e){
            System.out.println("Something went wrong...");
        }
    }

    void disp_trans(){
        try{
            File f = new File("inv_finance.csv");
            Scanner r = new Scanner(f);
            System.out.println("----------------------------------------");
            System.out.println("            Inventory Finance");
            System.out.println("----------------------------------------");
            int c = 1;

            while (r.hasNextLine()){
                String data = r.nextLine();
                String[] line = data.split(",");
                System.out.println(c + ". " + line[0] + "\n\tStock items:- " + line[1] + "\tTotal Price:-" + line[2] + "\n");
                c++;
            }

            r.close();
        }

        catch (FileNotFoundException e){
            System.out.println("Something went wrong...");
        }
    }

    void add_stock(){
        Scanner sc = new Scanner(System.in);
        int flag = 1;

        try{
            File f = new File("stock.csv");

            if(!f.exists()){
                f.createNewFile();
            }

            FileWriter fw = new FileWriter(f,true);
          	BufferedWriter bw = new BufferedWriter(fw);
          	PrintWriter pw = new PrintWriter(bw);

            while (flag == 1){
                System.out.print("\nEnter stock item name: ");
                String stname = sc.next();
                System.out.print("Enter stock item quantity: ");
                int stquan = sc.nextInt();
                pw.println(stname + "," + stquan);
                System.out.print("Do you want to continue (y/n): ");
                String con = sc.next();

                if (con.equals("n")){
                    flag = 0;
                }
            }

            pw.close();
        }

        catch (IOException e){
            System.out.println("Something went wrong...");
        }
    }

    void disp_stock(){
        try{
            File f = new File("stock.csv");
            Scanner r = new Scanner(f);
            System.out.println("----------------------------------------");
            System.out.println("                 Stock");
            System.out.println("----------------------------------------");
            int c = 1;

            while (r.hasNextLine()){
                String data = r.nextLine();
                String[] line = data.split(",");
                System.out.println(c + ". " + line[0] + "\n\tStock items:- " + line[1] + "\n");
                c++;
            }

            r.close();
        }

        catch (FileNotFoundException e){
            System.out.println("Something went wrong...");
        }
    }
}
