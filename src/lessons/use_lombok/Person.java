package lessons.use_lombok;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Person {
    String name;
    int age;
}

class TestLombok {
    public static void main(String[] args) {
        Person john = Person
                .builder()
                .age(10)
                .name("John")
                .build();
    }
}


