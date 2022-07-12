import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class waiter_opt{
    LinkedList items = new LinkedList();
    ArrayList<Integer> quantity = new ArrayList<Integer>();
    Queue ppi = new Queue(100);

    void order(){
        Scanner sc = new Scanner(System.in);
        int flag = 1;

        while (flag == 1){
            System.out.print("Enter item name: ");
            String ite = sc.next();
            System.out.print("Enter quantity: ");
            int qua = sc.nextInt();
            System.out.print("Enter price per item: ");
            int per = sc.nextInt();
            items.add(ite);
            quantity.add(qua);
            ppi.enqueue(per);
            System.out.print("Do you want to continue (y/n): ");
            String con = sc.next();

            if (con.equals("n")){
                flag = 0;
            }
        }

        try{
            File f = new File("order.csv");

            if(!f.exists()){
                f.createNewFile();
            }

            FileWriter fw = new FileWriter(f, true);
  	        BufferedWriter bw = new BufferedWriter(fw);
  	        PrintWriter pw = new PrintWriter(bw);

            pw.println("NEW");

            for (int i = 0; i < items.size(); i++){
                int temp = ppi.dequeue();
                ppi.enqueue(temp);
                pw.println(items.get(i) + "," + quantity.get(i) + "," + temp);
            }

            pw.close();
        }

        catch (IOException e){
            System.out.println("Something went wrong...");
        }
    }
}   