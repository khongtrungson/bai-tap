package TH10.bai1;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyFilterInputStream extends FilterInputStream {
    /**
     * Creates a {@code FilterInputStream}
     * by assigning the  argument {@code in}
     * to the field {@code this.in} so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or {@code null} if
     *           this instance is to be created without an underlying stream.
     */
    protected MyFilterInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int data = super.read();
        return (data == -1) ? data : Character.toLowerCase(data);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int n = super.read(b, off, len);
        if (n != -1) {
            for (int i = off; i < off + n; i++) {
                b[i] = (byte) Character.toLowerCase(b[i]);
            }
        }
        return n;
    }

}
