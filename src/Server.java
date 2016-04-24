import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket mServerSocket;
    private String message = "";
    private static int SERVER_PORT = 8080;
    private static String SERVER_IP = "192.168.1.109";


    public Server() {
        Thread mSocketServerThread = new Thread(new SocketServerThread());
        mSocketServerThread.start();
    }

    public void onDestroy(){
        if (mServerSocket != null){
            try {
                mServerSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class SocketServerThread extends Thread {
        int count = 0;

        @Override
        public void run() {
            try {
                mServerSocket = new ServerSocket(SERVER_PORT);
                while (true) {
                    Socket socket = mServerSocket.accept();
                    count++;
                    message += "#" + count + " from "
                            + socket.getInetAddress() + ":"
                            + socket.getPort() + "\n";

                    System.out.print(message);

                    SocketServerReplyThread mSocketServerReplyThread =
                            new SocketServerReplyThread(socket, count);
                    mSocketServerReplyThread.run();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class SocketServerReplyThread extends Thread {
        private Socket hostThreadSocket;
        int cnt;

        SocketServerReplyThread(Socket socket, int c) {
            hostThreadSocket = socket;
            cnt = c;
        }

        @Override
        public void run() {
            OutputStream mOutputStream;
            String msgReply = "Hello from Server,you are #" + cnt;

            try {
                mOutputStream = hostThreadSocket.getOutputStream();
                PrintStream mPrintStream = new PrintStream(mOutputStream);
                mPrintStream.print(msgReply);
                mPrintStream.close();
                message += "replayed: " + msgReply + "\n";

                System.out.print(message);
            } catch (IOException e) {
                e.printStackTrace();
                message += "Something wrong! " + e.toString() + "\n";
            }

            System.out.print(message);
        }
    }

}

