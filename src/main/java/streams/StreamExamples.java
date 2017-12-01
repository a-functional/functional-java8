package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamExamples {

    public static Supplier<List<Hosting>> HOSTINGS = () -> Arrays.asList(
            new Hosting(1, "liquidweb.com", 80000),
            new Hosting(2, "linode.com", 90000),
            new Hosting(3, "digitalocean.com", 120000),
            new Hosting(4, "aws.amazon.com", 200000),
            new Hosting(5, "mkyong.com", 1)
    );

    public static Supplier<List<Integer>> INTS = () -> Stream.of(2, 4, 6, 9, 10, 15, 37, 99, 237, 63, 76).collect(toList());


    public static class Hosting {
        private int id;
        private String name;
        private long websites;

        public Hosting(int id, String name, long websites) {
            this.id = id;
            this.name = name;
            this.websites = websites;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public long getWebsites() {
            return websites;
        }
    }
}
