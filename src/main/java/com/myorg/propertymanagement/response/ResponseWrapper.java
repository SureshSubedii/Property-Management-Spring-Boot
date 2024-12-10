package com.myorg.propertymanagement.response;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseWrapper extends HttpServletResponseWrapper {
    private final CharArrayWriter charArrayWriter = new CharArrayWriter();
    private final PrintWriter writer = new PrintWriter(charArrayWriter);

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() {
        return writer;
    }

    // Capture the response body
    public String getCapturedResponseBody() {
        return charArrayWriter.toString();
    }

    // Ensure the response body is written back to the original response output stream
    public void copyBodyToResponse() throws IOException {
        // Get the original writer and write the captured content
        PrintWriter originalWriter = super.getWriter();
        originalWriter.write(charArrayWriter.toString());
        originalWriter.flush();
    }
}
