import java.util.*;

public class CafeManagementCafe{
    public static void main(String[] args){
        System.out.println("================================================================================");
        System.out.println("                           Cafe Management System");
        System.out.println("================================================================================");
        
        Scanner sc = new Scanner(System.in);
        int ch, f1 = 1, f2, fun;
        login log = new login();


        while (f1 == 1){
            f2 = 1;
            System.out.println("\nEnter user role:-");
            System.out.println("\t1. Customer");
            System.out.println("\t2. Waiter");
            System.out.println("\t3. Cashier");
            System.out.println("\t4. Inventory Manager");
            System.out.print("\t5. Manager\n\t6. Exit\n> ");

            ch = sc.nextInt();
            System.out.println();
            switch(ch)

            {
                case 1:
                    {
                        customer_opt obj = new customer_opt();
                        
                        while (f2 == 1){
                            System.out.println("\n               CUSTOMER\n");
                            System.out.print("1. Menu\n2. Feedback\n3. Exit\n> ");
                            fun = sc.nextInt();

                            switch(fun)
                            {
                                case 1:
                                {
                                    obj.display_menu();
                                    break;
                                }

                                case 2:
                                {
                                    obj.feedback();
                                    break;
                                }

                                case 3:
                                {
                                    f2 = 0;
                                    break;
                                }
                            }
                        }

                        break;
                    }

                case 2:
                    {
                        log.wait_log();
                        
                        while (f2 == 1){
                            System.out.println("\n               WAITER\n");
                            System.out.print("1. Place new order\n2. Logout\n> ");
                            fun = sc.nextInt();
                            waiter_opt obj = new waiter_opt();

                            switch(fun)
                            {
                                case 1:
                                {
                                    obj.order();
                                    break;
                                }

                                case 2:
                                {
                                    f2 = 0;
                                }
                            }
                        }

                        break;
                    }

                case 3:
                {
                    {
                        log.cash_log();
                        
                        while (f2 == 1){
                            System.out.println("\n               CASHIER\n");
                            System.out.print("1. Generate bill\n2. Display bill\n3. Display finance\n4. Logout\n> ");
                            cashier_opt obj = new cashier_opt();
                            fun = sc.nextInt();

                            switch(fun)
                            {
                                case 1:
                                {
                                    obj.bill_generate();
                                    break;
                                }

                                case 2:
                                {
                                    obj.bill_display();
                                    break;
                                }

                                case 3:
                                {
                                    obj.disp_fin();
                                    break;
                                }

                                case 4:
                                {
                                    f2 = 0;
                                }
                            }
                        }

                        break;
                    }
                }

                case 4:
                {
                    {
                        log.inv_log();
                        
                        while (f2 == 1){
                            System.out.println("\n               INVENTORY MANAGER\n");
                            System.out.print("1. Add new transaction\n2. Display Transactions\n3. Add new stock\n4. View Stocks\n5. Logout\n> ");
                            fun = sc.nextInt();
                            inv_opt obj = new inv_opt();

                            switch(fun)
                            {
                                case 1:
                                {
                                    obj.add_trans();
                                    break;
                                }

                                case 2:
                                {
                                    obj.disp_trans();
                                    break;
                                }

                                case 3:
                                {
                                    obj.add_stock();
                                    break;
                                }

                                case 4:
                                {
                                    obj.disp_stock();
                                    break;
                                }

                                case 5:
                                {
                                    f2 = 0;
                                }
                            }
                        }

                        break;
                    }
                }

                case 5:
                {
                    {
                        log.adm_log();
                        
                        while (f2 == 1){
                            System.out.println("\n               MANAGER\n");
                            System.out.print("1. View customer feedback\n2. View cashier finance\n3. View inventory finance\n4. View stocks\n5. View menu\n6. Change menu\n7. Logout\n> ");
                            fun = sc.nextInt();
                            admin_opt obj = new admin_opt();

                            switch(fun)
                            {
                                case 1:
                                {
                                    obj.view_feed();
                                    break;
                                }

                                case 2:
                                {
                                    obj.view_cashier_fin();
                                    break;
                                }

                                case 3:
                                {
                                    obj.view_inv_fin();
                                    break;
                                }

                                case 4:
                                {
                                    obj.view_stocks();
                                    break;
                                }

                                case 5:
                                {
                                    obj.view_menu();
                                    break;
                                }

                                case 6:
                                {
                                    obj.change_manu();
                                    break;
                                }

                                case 7:
                                {
                                    f2 = 0;
                                }
                            }
                        }

                        break;
                    }
                }

                case 6:
                {
                    f1 = 0;
                    break;
                }
            }
        }
    }
}
