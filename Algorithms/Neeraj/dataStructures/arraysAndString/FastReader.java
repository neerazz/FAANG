import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class FastReader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public FastReader() {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public FastReader(String file_name) {
        try {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readLine() {
        StringBuilder sb = new StringBuilder();
        byte c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                break;
            }
            sb.append((char) c);
        }
        return sb.toString();
    }

    public String readLine(int size) {
        byte[] buf = new byte[size];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                break;
            }
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() {
        int n = 0;
        boolean neg = false;
        int c;
        while ((c = read()) <= ' ') ;
        neg = c == '-';
        if (neg) {
            c = read();
        }
        do {
            n = n * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (c == 13) {
            read();
        }
        return neg ? -n : n;
    }

    public long nextLong() {
        long n = 0;
        boolean neg = false;
        int c;
        while ((c = read()) <= ' ') ;
        neg = c == '-';
        if (neg) {
            c = read();
        }
        do {
            n = n * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (c == 13) {
            read();
        }
        return neg ? -n : n;
    }

    public double nextDouble() {
        double n = 0, div = 1;
        boolean neg = false;
        int c;
        while ((c = read()) <= ' ') ;
        neg = c == '-';
        if (neg) {
            c = read();
        }
        do {
            n = n * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                n += (c - '0') / (div *= 10);
            }
        }
        if (c == 13) {
            read();
        }
        return neg ? -n : n;
    }

    private void fillBuffer() {
        try {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte read() {
        if (bufferPointer == bytesRead) {
            fillBuffer();
        }
        return buffer[bufferPointer++];
    }

    public void close() {
        try {
            if (din == null) {
                return;
            } else {
                din.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}