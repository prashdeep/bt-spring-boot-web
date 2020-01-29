package com.bt.itemmgmt.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPasswordEncoderUtil {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String rawString = "welcome";

        String cipherText1 = passwordEncoder.encode(rawString);
        String cipherText2 = passwordEncoder.encode(rawString);
        String cipherText3 = passwordEncoder.encode(rawString);
        String cipherText4 = passwordEncoder.encode(rawString);

        System.out.println("Cipher Text "+cipherText1);
        System.out.println("Cipher Text "+cipherText2);
        System.out.println("Cipher Text "+cipherText3);
        System.out.println("Cipher Text "+cipherText4);

        passwordEncoder.matches("welcome", cipherText1);
        passwordEncoder.matches("welcome", cipherText2);
        passwordEncoder.matches("welcome", cipherText3);
        System.out.println(passwordEncoder.matches("welcome", cipherText4));

    }
}

