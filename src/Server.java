/**
 * Created by pirtea on 05.12.2015.
 */

import java.net.MalformedURLException;
import java.rmi.*;

public class Server {

    public static void main(String[] args){
        try {
            OperationEngine oe = new OperationEngine();

            String rmiObjectName = "rmi://localhost/OperationEngine";

            Naming.rebind(rmiObjectName, oe);

            System.out.println("Binding complete");
        }
        catch(RemoteException re){
            System.out.println(re.getMessage());
            re.printStackTrace();
        }
        catch (MalformedURLException mue){
            System.out.println(mue.getMessage());
            mue.printStackTrace();
        }
    }
}
