package cs_and_programming.week10;
import java.util.HashMap;
import java.util.Map;

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

    public void givenMap_whenequalsAndHashCodeNotOverridden_thenMemoryLeak() {
        Map<Person, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(new Person("json"), 1);
        }
        //Assert.assertFalse(map.size() == 1);
    }

    public class Person1 {
        public String name;

        public Person1(String name) {
            this.name = name;
        }

        //proper implementation, then above assertion in test will be true
        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Person1)) {
                return false;
            }
            Person1 person1 = (Person1) o;
            return person1.name.equals(name);
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + name.hashCode();
            return result;
        }
    }
}
