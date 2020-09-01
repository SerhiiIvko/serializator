import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SerializatorTest {

    private TestObject testObject;

    @Test
    public void serializeSimpleString() throws IOException {
        String some = "Some string";
        byte[] serialized = Serializator.serialize(some);
        assertNotNull(serialized);
    }

    @Test
    public void serializeNull() throws IOException {
        String some = null;
        byte[] serialized = Serializator.serialize(some);
        assertNotNull(serialized);
    }

    @Test
    public void serializeObject() throws IOException, ClassNotFoundException {
        testObject = new TestObject();
        int age = 23;
        String name = "Bill";
        String firstFriend = "John";
        String secondFriend = "Neo";
        List<String> friends = new ArrayList<>();
        friends.add(firstFriend);
        friends.add(secondFriend);
        testObject.setAge(age);
        testObject.setName(name);
        testObject.setFriends(friends);
        byte[] serialized = Serializator.serialize(testObject);
        assertNotNull(serialized);
        assertTrue(serialized.length > 0);
    }

    @Test
    public void deserialize() throws IOException, ClassNotFoundException {
        testObject = new TestObject();
        int age = 23;
        String name = "Bill";
        String firstFriend = "John";
        String secondFriend = "Neo";
        List<String> friends = new ArrayList<>();
        friends.add(firstFriend);
        friends.add(secondFriend);
        testObject.setAge(age);
        testObject.setName(name);
        testObject.setFriends(friends);
        byte[] serialized = Serializator.serialize(testObject);
        Object result = Serializator.deserialize(serialized);
        TestObject newObj = (TestObject) result;
        assertNotNull(result);
        assertEquals(age, newObj.getAge());
        assertEquals(name, newObj.getName());
        assertEquals(friends, newObj.getFriends());
    }
}