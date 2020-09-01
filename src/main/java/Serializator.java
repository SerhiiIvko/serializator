import java.io.*;

public class Serializator {

    public static byte[] serialize(Object obj) throws IOException {
        try (ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream()) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream)) {
                objectOutputStream.writeObject(obj);
            }
            return arrayOutputStream.toByteArray();
        }
    }

    public static Object deserialize(byte[] serializedObj) throws IOException, ClassNotFoundException {
        try (ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(serializedObj)) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(arrayInputStream)) {
                return objectInputStream.readObject();
            }
        }
    }
}
