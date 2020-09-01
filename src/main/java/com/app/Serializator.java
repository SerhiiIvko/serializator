package com.app;

import com.app.exception.ApplicationException;

import java.io.*;

/**
 * Custom serialization class.
 * Contains util static methods for serialization object to byte array and for deserialization byte array to the object.
 */
public class Serializator {

    public static byte[] serialize(Object obj) throws IOException {
        try (ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream()) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream)) {
                if (obj != null) {
                    objectOutputStream.writeObject(obj);
                } else {
                    throw new ApplicationException();
                }
            }
            return arrayOutputStream.toByteArray();
        }
    }

    public static Object deserialize(byte[] serializedObj) throws IOException, ClassNotFoundException {
        if (serializedObj == null) {
            throw new ApplicationException();
        }
        try (ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(serializedObj)) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(arrayInputStream)) {
                return objectInputStream.readObject();
            }
        }
    }
}
