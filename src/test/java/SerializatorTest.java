import com.app.exception.ApplicationException;
import org.junit.Test;

import com.app.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SerializatorTest {

    private TestObject testObject;

    @Test
    public void serializeSimpleString() throws IOException {
        String simpleString = "Simple string";
        byte[] serialized = Serializator.serialize(simpleString);
        assertNotNull(serialized);
        assertTrue(serialized.length > 0);
    }

    @Test(expected = ApplicationException.class)
    public void serializeNull() throws IOException {
        String simpleString = null;
        Serializator.serialize(simpleString);
    }

    @Test
    public void serializeObject() throws IOException {
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
    public void deserializeSimpleObject() throws IOException, ClassNotFoundException {
        String simpleString = "Some string";
        byte[] serialized = Serializator.serialize(simpleString);
        String result = (String) Serializator.deserialize(serialized);
        assertNotNull(result);
        assertEquals(simpleString, result);
    }

    @Test(expected = ApplicationException.class)
    public void deserializeNullObject() throws IOException, ClassNotFoundException {
        byte[] serialized = null;
        Serializator.deserialize(serialized);
    }

    @Test
    public void deserializeCustomObjectWithFields() throws IOException, ClassNotFoundException {
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