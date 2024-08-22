package br.com.soat8.techchallenge.core.port.out;

import com.google.zxing.WriterException;

import java.io.IOException;

public interface QRCodePort {
    byte[] generateQRCodeImage(String text, int width, int height)  throws WriterException, IOException;
}
