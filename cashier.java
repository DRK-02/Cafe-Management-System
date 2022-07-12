import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class cashier_opt{
    DoubleLinkedList items = new DoubleLinkedList();
    ArrayList<String> quantity = new ArrayList<String>();
    ArrayList<Integer> price = new ArrayList<Integer>();
    int bill_amt = 0;

    void bill_generate(){
        Scanner sc = new Scanner(System.in);

        try{
            File f1 = new File("order.csv");
            Scanner r1 = new Scanner(f1);
            Stack lines = new Stack(100);

            while (r1.hasNextLine()){
                lines.push(r1.nextLine());
            }

            for (int i = 0; i < lines.getSize(); i++) {
                String line = lines.pop();

                if (line.contains(",")) {
                    String[] det = line.split(",");
                    int q = Integer.parseInt(det[1]);
                    int p = Integer.parseInt(det[2]);
                    items.add(det[0]);
                    quantity.add(det[1]);
                    price.add(q * p);
                    bill_amt += q * p;
                }

                else if (line.contains("NEW")) {
                    break;
                }

                r1.close();
            }

            System.out.println("Bill processing successful");
        }

        catch (FileNotFoundException e){
            System.out.println("Something went wrong...");
        }

        try{
            File f2 = new File("cash_finance.csv");

            if(!f2.exists()){
                f2.createNewFile();
            }

            FileWriter fw = new FileWriter(f2, true);
          	BufferedWriter bw = new BufferedWriter(fw);
          	PrintWriter pw = new PrintWriter(bw);

            pw.println("NEW");

            for (int i = 0; i < items.size(); i++){
                pw.println(items.get(i) + "," + quantity.get(i) + "," + price.get(i));
            }

            pw.println(bill_amt);
            pw.close();
        }

        catch (IOException e){
            System.out.println("Something went wrong...");
        }
    }

    void bill_display(){
        System.out.println("----------------------------------------");
        System.out.println("                  Bill");
        System.out.println("----------------------------------------");

        try{
            File f1 = new File("cash_finance.csv");
            Scanner r1 = new Scanner(f1);
            Stack lines = new Stack(100);

            while (r1.hasNextLine()){
                lines.push(r1.nextLine());
            }

            for (int i = 0; i < lines.getSize(); i++) {
                String line = lines.pop();

                if (line.contains(",")) {
                    String[] det = line.split(",");
                    System.out.println(i + ". " + det[0] + "\n\tQuantity:-" + det[1] + "\n\tPrice:- Rs." + det[2] + "\n");
                }

                else if (line.contains("NEW")) {
                    break;
                }

                else{
                    System.out.println("Total Amount: " + line + "\n");
                }

                r1.close();
            }

            r1.close();
        }

        catch (FileNotFoundException e){
            System.out.println("Something went wrong...");
        }

        items.clear();
        quantity.clear();
        price.clear();
        bill_amt = 0;
    }

    void disp_fin(){
        try{
            File f = new File("cash_finance.csv");
            Scanner r = new Scanner(f);
            System.out.println("----------------------------------------");
            System.out.println("            Cashier Finance");
            System.out.println("----------------------------------------");
            int c = 1;

            while (r.hasNextLine()){
                String line = r.nextLine();

                if (line.contains(",")) {
                    String[] det = line.split(",");
                    System.out.println(c + ". " + det[0] + "\n\tQuantity:-" + det[1] + "\n\tPrice:- Rs." + det[2] + "\n");
                    c++;
                }

                else if (line.contains("NEW")) {
                    continue;
                }

                else{
                    System.out.println("\tTotal Amount: " + line + "\n");
                }

            }

            r.close();
        }

        catch (FileNotFoundException e){
            System.out.println("Something went wrong...");
        }
    }
}