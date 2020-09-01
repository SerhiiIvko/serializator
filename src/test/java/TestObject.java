import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TestObject implements Serializable {

    private int age;
    private String name;
    private List<String> friends;

}
