package exercise;

import lombok.Value;

// BEGIN
@Value
// END
class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
}
