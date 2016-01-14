import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Worst_RMI_Calculator Server
 * Created by pirtea on 20.11.2015.
 */
public class OperationEngine  extends UnicastRemoteObject implements IOperation {

    //  constructor for ComputeEngine instances.
    public OperationEngine()  throws  RemoteException {
        super();
        //  the no-argument constructor of the Object class
    }

    //   implementations for each remote method specified in the remote interfaces
    public double Adunare(double a, double b) { return a + b; }

    public double Scadere(double a, double b){ return a - b; }

    public double Inmultire(double a, double b) {
        return a * b;
    }

    public double Impartire(double a, double b)  {
        return a / b;
    }

    public double Inversare(double a) {
        return (-1) * a;
    }

    public double RidicarePutere(double a,double b) {
        return Math.pow(a, b);
    }

    public int Factorial(int a) {
        int aux = 1;
        for(int i=a; i>=2 ;i--){
            aux *= i;
        }
        return aux;
    }

    public double RadacinaPatrata(double a) {
        return Math.sqrt(a);
    }

    //main method that is used to create a ComputeEngine instance and make it available to clients.
    public static void main(String[] args){

//        System.setProperty("java.security.policy","file:./grantaccess.policy");

        //  Create and install a security manager
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
        try{
            //  Create and export one or more remote objects
            String name = "IOperation";
            IOperation engine = new OperationEngine();

            // param#2 - port; 0 for anonymous port
            /*      Note that the type of the variable stub must be IOperation, not OperationEngine,
                because the stub for a remote object only implements the remote interfaces that the exported remote object
                implements.
            */
            IOperation stub = (IOperation) UnicastRemoteObject.exportObject(engine,0);

            //  Register at least one remote object with the RMI registry
            // register def. - simple remote object naming service that enables clients to obtain a reference to a remote object by name
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name,stub);
            System.out.println("OperationEngine bound");

        }catch (RemoteException re){
            System.out.println("ComputeEngine exception: "+re.getMessage());
            re.printStackTrace();
        }
    }
}
