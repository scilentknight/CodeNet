// 2. WAP to write content into the server time.nist.gov at port 13 and then read the content using socket. (2022_14_Prakash)
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SockerWrite {
    public static void main(String[] args) {
        // create socket
        // set timeout
        // open outputStream
        // open inputStream
        // writer write
        // flush writer
        // read response from inputStream
        // close socket
        try{
            Socket socket = new Socket("time.nist.gov",13);
            socket.setSoTimeout(10000);
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            Writer writer = new OutputStreamWriter(out);
            writer.write("hello\r\n");
            writer.write("server\r\n");
            writer.flush();

            InputStreamReader reader = new InputStreamReader(in, "UTF-8");
            StringBuilder content = new StringBuilder();
            for (int n = reader.read(); n!=-1; n= reader.read()){
                content.append((char)n);
            }
            System.out.println("Server content: "+content);
            out.close();
            in.close();
            socket.close();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
