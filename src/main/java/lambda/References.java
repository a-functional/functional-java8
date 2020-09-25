package lambda;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class References {

  public static void main(String[] args) {
    final ArrayList<Integer> ages = Lists.newArrayList(12, 30, 44, 50);

    final Collection<Age> mappedAges =
        ages.stream()
            .map(Age::new)
            .collect(Collectors.toList());
    System.err.println(mappedAges);
  }

  private static class Age {

    private final int age;

    public Age(int age) {
      this.age = age;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("age", age)
          .toString();
    }
  }

}
