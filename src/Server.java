/**
 * Created by pirtea on 05.12.2015.
 */

import java.rmi.*;

public class Server {

    public static void main(String[] args) throws Exception{
        OperationEngine oe = new OperationEngine();

        String rmiObjectName = "rmi://localhost/OperationEngine";

        Naming.rebind(rmiObjectName,oe);

        System.out.println("Binding complete");
    }
}
