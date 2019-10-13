package Main;

import Service.Service;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import java.io.*;
import java.net.Socket;

public class Client_Socket {

    final static Logger LOGGER = Logger.getLogger(Client_Socket.class);

    private static Socket clientSocket; // сокет для общения
    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
    // мы узнаем что хочет сказать клиент?
//    private static BufferedInputStream in; // поток чтения из сокета
//    private static BufferedOutputStream out; // поток записи в сокет

    private static InputStream sin;
    private static OutputStream sout;

    private static DataInputStream in;
    private static DataOutputStream out;

    public static void socket() {
        try {
            clientSocket = new Socket("localhost", 8081); // этой строкой мы запрашиваем
            reader = new BufferedReader(new InputStreamReader(System.in));
            // читать соообщения с сервера
            sin = clientSocket.getInputStream();
            sout = clientSocket.getOutputStream();

            in = new DataInputStream(sin);
            out = new DataOutputStream(sout);
//            answer();
//            Service.func(new JSONObject(in.readUTF()));
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    public static void postMessage(JSONObject json) {
        try {
            out.writeUTF(json.toString());
            out.write(json.toString().getBytes()); // отправляем сообщение на сервер
            out.flush();
        } catch (IOException e) {
            LOGGER.error(e);
        }
        answer();
    }

    public static void answer() {
        try {
            Service.parse_answer(new JSONObject(in.readUTF()));
        } catch (IOException e) {
            LOGGER.error(e);
        }
//        } finally {
//            try {
//                clientSocket.close();
//                in.close();
//                out.close();
//                LOGGER.info("Socket was close.");
//            } catch (IOException e) {
//                LOGGER.error(e);
//            }
//        }
    }

}
