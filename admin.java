import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class admin_opt{
    void view_feed(){
        try{
            File f = new File("feedback.txt");
            Scanner r = new Scanner(f);
            System.out.println("----------------------------------------");
            System.out.println("               FEEDBACK");
            System.out.println("----------------------------------------");
            int i = 1;

            while (r.hasNextLine()){
                String data = r.nextLine();
                System.out.println(i + ". " + data);
                i++;
            }

            r.close();
        }

        catch (FileNotFoundException e){
            System.out.println("Something went wrong...");
        }
    }

    void view_cashier_fin(){
        cashier_opt fin = new cashier_opt();
        fin.disp_fin();
    }

    void view_inv_fin(){
        inv_opt fin = new inv_opt();
        fin.disp_trans();
    }

    void view_stocks(){
        inv_opt fin = new inv_opt();
        fin.disp_stock();
    }

    void view_menu(){
        customer_opt fin = new customer_opt();
        fin.display_menu();
    }

    void change_manu(){
        Scanner sc = new Scanner(System.in);
        int flag = 1;

        try{
            File f = new File("menu.txt");

            if(!f.exists()){
                f.createNewFile();
            }

            FileWriter fw = new FileWriter(f,true);
          	BufferedWriter bw = new BufferedWriter(fw);
          	PrintWriter pw = new PrintWriter(bw);

            while (flag == 1){
                System.out.print("Enter item name: ");
                String name = sc.next();
                System.out.print("Enter item price: ");
                int price = sc.nextInt();
                pw.println(name + "\t\t\t" + price);
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
}