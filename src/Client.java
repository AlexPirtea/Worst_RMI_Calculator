import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by pirtea on 05.01.2016.
 */
public class Client {

    private static double rez = 0.0;
    private static char  command;
    private static double input;
    private static double memorie = 0.0;

    public static void main(String args[]) {
//        System.setProperty("java.security.policy","file:./grantaccess.policy");

//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
        try {
            String name = "OperationEngine";
            Registry registry = LocateRegistry.getRegistry();
            IOperation comp = (IOperation) registry.lookup(name);

            java.util.Scanner keyboard = new java.util.Scanner(System.in);

            ShowMenu();
            while((command = keyboard.next().toCharArray()[0] ) != 'q'){
                switch(command){
                    case '1':
                        System.out.print("Adunare: " + rez +  " + "  );
                        input = keyboard.nextDouble();
                        rez = comp.Adunare(rez,input);
                        break;

                    case '2':
                        System.out.print("Scaredere: " + rez + " - ");
                        input = keyboard.nextDouble();
                        rez = comp.Scadere(rez,input);
                        break;

                    case '3':
                        System.out.print("Inmultire: " + rez + " * ");
                        input = keyboard.nextDouble();
                        rez = comp.Inmultire(rez,input);
                        break;

                    case '4':
                        System.out.print("Impartire: " + rez + " \\ ");
                        input = keyboard.nextDouble();

                        if(input == 0.00){
                            System.out.println("Err: Impartire la 0");
                            break;
                        }
                        rez = comp.Impartire(rez,input);
                        break;

                    case '5':
                        rez = comp.Inversare(rez);
                        break;

                    case '6':
                        System.out.print("Ridicare la putere: " + rez + " ^ ");
                        input = keyboard.nextDouble();
                        rez = comp.RidicarePutere(rez,input);
                        break;

                    case '7':
                        if(rez != Math.floor(rez) || Double.isInfinite(rez)){
                            System.out.println("Err: Nu se poate face factorial daca numarul nu este intreg");
                            break;
                        }
                        rez = comp.Factorial((int)rez);
                        break;

                    case '8':
                        if(rez < 0.00){
                            System.out.println("Err: Valoare negativa");
                            break;
                        }
                        rez = comp.RadacinaPatrata(rez);

                        break;

                    case 'a':
                        memorie += rez;
                        break;

                    case 'b':
                        memorie -= rez;
                        break;

                    case 'c':
                        memorie = rez;
                        break;

                    case 'd':
                        rez = memorie;
                        break;

                    case 'e':
                        memorie = 0.00;
                        break;

                    default:
                        System.out.println("Comanda necunoscuta ...");
                        break;
                }

                ShowMenu();
            }

        } catch (Exception e) {
            System.err.println("IOperation exception:");
            e.printStackTrace();
        }
    }

    private static void ShowMenu(){
        System.out.println("Memorie: " + memorie);
        System.out.println("Rezultat: " + rez);

        System.out.println("\n\nAlege o operatie:" +
                "\n------------------------------" +
                "\n|\t1.Adunare\t\t\t\t|" +
                "\n|\t2.Scadere\t\t\t\t|" +
                "\n|\t3.Inmultire\t\t\t\t|" +
                "\n|\t4.Impartire\t\t\t\t|" +
                "\n|\t5.Inversare\t\t\t\t|" +
                "\n|\t6.Ridicare la putere\t|" +
                "\n|\t7.Factorial\t\t\t\t|" +
                "\n|\t8.Radacina patrata\t\t|" +
                "\n|\t\t\t\t\t\t\t|"+
                "\n|\tOpratii cu memoria\t\t|" +
                "\n|\t\t\t\t\t\t\t|"+
                "\n|\ta.Adunare\t\t\t\t|" +
                "\n|\tb.Scadere\t\t\t\t|" +
                "\n|\tc.Stocare\t\t\t\t|" +
                "\n|\td.Citire\t\t\t\t|" +
                "\n|\te.Stargere\t\t\t\t|" +
                "\n------------------------------" +
                "\n\nq.Quit" +
                "\n");

        System.out.print("Operatie:\t");
    }
}
