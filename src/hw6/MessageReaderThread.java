package hw6;

import java.io.DataInputStream;
import java.io.IOException;

public class MessageReaderThread extends Thread {
    private  final DataInputStream dataInputStream;

    public MessageReaderThread(DataInputStream dataInputStream){
        this.dataInputStream = dataInputStream;
    }

    @Override
    public void run(){
        do{
            try{
                System.out.println(dataInputStream.readUTF());
            } catch (IOException e){
                e.printStackTrace();
            }
        }while (true);
    }
}
