import java.util.*;

interface wait_log{
    void wait_log();
}

interface cash_log{
    void cash_log();
}

interface inv_log{
    void inv_log();
}

interface adm_log{
    void adm_log();
}

class login implements wait_log, cash_log, inv_log, adm_log{
    Scanner sc = new Scanner(System.in);

    int user, pwd;

    public void wait_log() {
        Scanner sc = new Scanner(System.in);

        final int usname = 001;
        final int pass = 3003;

        for(int i = 0; i < 3; i++){
            if (i < 2){
                System.out.println("Username: ");
                user = sc.nextInt();
                System.out.println("Password: ");
                pwd = sc.nextInt();        
            
                if ((usname == user) && (pass == pwd)){
                    System.out.println("");
                    break;
                }

                else {
                    System.out.println("Wrong username or password!!");
                    System.out.println("Please try again...");
                }
            }

            else{
                System.out.println("Timed out!!.....Too many login attempts.");
                System.exit(i);
                break;  
            }
        }
    }

    public void cash_log() {
        Scanner sc = new Scanner(System.in);

        final int usname = 002;
        final int pass = 1710;
    
        for(int i = 0; i < 3; i++){
            if (i < 2){
                System.out.println("Username: ");
                user = sc.nextInt();
                System.out.println("Password: ");
                pwd = sc.nextInt();        
            
                if ((usname == user) && (pass == pwd)){
                    System.out.println("");
                    break;
                }

                else {
                    System.out.println("Wrong username or password!!");
                    System.out.println("Please try again...");
                }
            }

            else{
                System.out.println("Timed out!!.....Too many login attempts.");
                System.exit(i);
                break;  
            }
        }
    }

    public void inv_log() {
        Scanner sc = new Scanner(System.in);

        final int usname = 003;
        final int pass = 1009;
    
        for(int i = 0; i < 3; i++){
            if (i < 2){
                System.out.println("Username: ");
                user = sc.nextInt();
                System.out.println("Password: ");
                pwd = sc.nextInt();        
            
                if ((usname == user) && (pass == pwd)){
                    System.out.println("");
                    break;
                }

                else {
                    System.out.println("Wrong username or password!!");
                    System.out.println("Please try again...");
                }
            }

            else{
                System.out.println("Timed out!!.....Too many login attempts.");
                System.exit(i);
                break;  
            }
        }
    }

    public void adm_log() {
        Scanner sc = new Scanner(System.in);

        final int usname = 004;
        final int pass = 2910;
    
        for(int i = 0; i < 3; i++){
            if (i < 2){
                System.out.println("Username: ");
                user = sc.nextInt();
                System.out.println("Password: ");
                pwd = sc.nextInt();        
            
                if ((usname == user) && (pass == pwd)){
                    System.out.println("");
                    break;
                }

                else {
                    System.out.println("Wrong username or password!!");
                    System.out.println("Please try again...");
                }
            }

            else{
                System.out.println("Timed out!!.....Too many login attempts.");
                System.exit(i);
                break;  
            }
        }
    }
}