package com.example.sec6_2111652_finalexam;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendableObjectOutputStream2111652 extends ObjectOutputStream {
    public AppendableObjectOutputStream2111652(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // do nothing
    }
}
