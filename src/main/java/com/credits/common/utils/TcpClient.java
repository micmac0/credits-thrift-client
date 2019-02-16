package com.credits.common.utils;

import com.credits.common.exception.CreditsCommonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(TcpClient.class);

    public static String sendRequest(String host, int port, String request) throws CreditsCommonException
    {
        LOGGER.info("Sending request [{}] to tcp [{}:{}]", request, host, port);
        Socket socket = null;
        try {
            socket = new Socket(host, port);
            DataInputStream is = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream os = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            // Send Client Request to Server
            send(os, request.getBytes(StandardCharsets.US_ASCII));
            // Receive Server Response
            byte[] byteData = receive(is);
            String responseData = new String(byteData);
            LOGGER.info("Response from tcp [{}]", responseData);
            return responseData;
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new CreditsCommonException(e);
        }
    }

     //Method receives the Server Response
    public static byte[] receive(DataInputStream is) throws CreditsCommonException {
        byte[] inputData = new byte[1024];
        try {
            is.read(inputData);
        } catch (IOException e) {
            throw new CreditsCommonException(e);
        }
        return inputData;
    }

     //Method used to Send Request to Server
    public static void send(DataOutputStream os, byte[] byteData) throws CreditsCommonException {
        try {
            os.write(byteData);
            os.flush();
        } catch (IOException e) {
            throw new CreditsCommonException(e);
        }

    }
}
