import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IOperation extends Remote {

    double Adunare(double a, double b) throws RemoteException;

    double Scadere(double a, double b) throws  RemoteException;

    double Inmultire(double a,double b) throws RemoteException;

    double Impartire(double a, double b) throws RemoteException;

    double Inversare(double a) throws RemoteException;

    double RidicarePutere(double a, double b) throws RemoteException;

    int Factorial(int a) throws RemoteException;

    double RadacinaPatrata(double a) throws RemoteException;
}
