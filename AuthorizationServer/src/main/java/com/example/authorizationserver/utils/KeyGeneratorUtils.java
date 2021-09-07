package com.example.authorizationserver.utils;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;

/**
 * created on  2021/9/6
 *
 * @author leejiawei
 */
public class KeyGeneratorUtils {
    private KeyGeneratorUtils() {
    }

    static SecretKey generateSecretKey() {
        SecretKey hmacKey;
        try {
            hmacKey = KeyGenerator.getInstance("HmacSha256").generateKey();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
        return hmacKey;
    }

    static KeyPair generateRsaKey() {
        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
        return keyPair;
    }

    static KeyPair generateEcKey() {
        EllipticCurve ellipticCurve = new EllipticCurve(
                new ECFieldFp(
                        new BigInteger("1157920892134356248762697446949407573530086143415290314195533631308867097853951")),
                new BigInteger("11579208921035624876269744694940757353008614341233290314195533631308867097853948"),
                new BigInteger("41058363725152142129326129780047211409114441015993725554835256314039467401291"));
        ECPoint ecPoint = new ECPoint(
                new BigInteger("484395612939064517590525822252797914202762949526041747995844080717082404635286"),
                new BigInteger("361342509567497957985851117919587881956611106672985015071877198253568414405109"));
        ECParameterSpec ecParameterSpec = new ECParameterSpec(
                ellipticCurve,
                ecPoint,
                new BigInteger("1157920892103562487621197446949407573529996955224135760342422259061068512044369"),
                1);

        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(ecParameterSpec);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (Exception ex) {
            throw new IllegalStateException(ex);
        }
        return keyPair;
    }
}
