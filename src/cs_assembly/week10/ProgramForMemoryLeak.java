package cs_assembly.week10;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProgramForMemoryLeak {

    public class Person {
        public String name;

        public Person(String name) {
            this.name = name;
        }
    }

    //Insert duplicate Person objects into a Map that uses this key
    //Here we’re using Person as a key. Since Map doesn’t allow duplicate keys, the numerous duplicate Person objects that we inserted as a key shouldn’t increase the memory.
    //
    //But since we haven’t defined the proper equals() method, the duplicate objects pile up and increase the memory, which is why we see more than one object in the memory.
    @Test
    public void givenMap_whenequalsAndHashCodeNotOverridden_thenMemoryLeak() {
        Map<Person, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(new Person("json"), 1);
        }
        Assert.assertFalse(map.size() == 1);
    }

    public class Person1 {
        public String name;

        public Person1(String name) {
            this.name = name;
        }

        //proper implementation
        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Person)) {
                return false;
            }
            Person person = (Person) o;
            return person.name.equals(name);
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + name.hashCode();
            return result;
        }
    }
}
