package tmc.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tmc.core.Game;

/**
 *
 * @author Luca Kölzsch
 */
public class StorageHandler {
    
    
    private final String notation = "game#";
    
    FileOutputStream fileOutputStream;
    ObjectOutputStream objectOutputStream;
    
    FileInputStream fileInputStream;
    ObjectInputStream objectInputStream;

    public StorageHandler() {
        
    }
    
    public boolean save(Game game) throws FileNotFoundException, IOException {
        fileOutputStream = new FileOutputStream(notation + game.getID());
        objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(game);
        objectOutputStream.close();
        return true;
    }
    
    public Game load(int ID) throws IOException, ClassNotFoundException {
        fileInputStream = new FileInputStream(notation + ID);
        objectInputStream = new ObjectInputStream(fileInputStream);
        return (Game) objectInputStream.readObject();
    }
}
