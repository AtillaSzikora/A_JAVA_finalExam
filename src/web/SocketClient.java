package web;

import entity.Person;
import entity.SearchType;
import server.PersonStoreSocketServer;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Set;

public class SocketClient {

    public static final String HOST = "localhost";
    String searchCriteria;
    SearchType searchType;

    public SocketClient(String searchCriteria, SearchType searchType) {
        this.searchCriteria = searchCriteria;
        this.searchType = searchType; }

    public Set<Person> getPersons() {
        try {
            Socket socket = new Socket(HOST, PersonStoreSocketServer.PORT);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            oos.writeObject(searchCriteria);
            oos.writeObject(searchType);

            ois.close();
            oos.close();
            socket.close();
        } catch (Exception e) {e.printStackTrace();}
        return null; }
}
