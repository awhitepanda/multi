package stream;

import java.io.*;

public class StreamImpl {
    public static String readPath = "D:\\ProgramData\\Git\\my.project.test\\IdeaProjects\\multi\\unJava\\src\\read.txt";
    public static String writePath = "D:\\ProgramData\\Git\\my.project.test\\IdeaProjects\\multi\\unJava\\src\\write.txt";

    public static void FileStream() throws IOException {
        File fr = new File(readPath);
        File fw = new File(writePath);

        InputStream inputStream = new FileInputStream(fr);
        OutputStream outputStream = new FileOutputStream(fw);

        byte[] buffer = new byte[1024];
        long dataLength = fr.length();
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
        outputStream.flush();

        outputStream.close();
        inputStream.close();
    }

    public static void DataInputStreamImpl() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(StreamImpl.readPath));
        byte[] b = new byte[2];
        dis.read(b);
        System.out.println(new String(b, 0, 2));

        char[] c = new char[2];
        for (int i = 0; i < 2; i++) {
            c[i] = dis.readChar();
        }
        System.out.println(new String(c, 0, 2));

        System.out.println(dis.readUTF());

        dis.close();
    }

    public static void DataOutputStreamImpl() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(StreamImpl.writePath));

        dos.writeBytes("世界"); //按2字节写入，都是写入的低位
        dos.writeChars("世界"); // 按照Unicode写入

        // 按照UTF-8写入(UTF8变长，开头2字节是由writeUTF函数写入的长度信息，方便readUTF函数读取)
        dos.writeUTF("世界");
        dos.flush();
        dos.close();
    }

}
