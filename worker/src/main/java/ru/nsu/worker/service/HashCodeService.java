package ru.nsu.worker.service;

import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class HashCodeService {

    private final MessageDigest messageDigest;

    public HashCodeService() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("MD5");
    }

    public String getMd5Hash(byte[] bytes) {
        return DatatypeConverter.printHexBinary(messageDigest.digest(bytes));
    }
}
