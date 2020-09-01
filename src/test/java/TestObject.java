import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Class to demonstrate the need to customize serialization.
 */
@Data
public class TestObject implements Serializable {

    static final long serialVersionUID = 4321412L;
    private int age;
    private String name;
    private List<String> friends;

}
