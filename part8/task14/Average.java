package main.ru.mephi.java.part8.task14;

import java.util.stream.Stream;

public class Average {
    static class ImmutableAverager {
        private final double total;
        private final int count;

        public ImmutableAverager() {
            this.total = 0;
            this.count = 0;
        }

        public ImmutableAverager(double total, int count) {
            this.total = total;
            this.count = count;
        }

        public double average() {
            return count > 0 ? ((double) total) / count : 0;
        }

        public ImmutableAverager accept(double i) {
            return new ImmutableAverager(total + i, count + 1);
        }

        public ImmutableAverager combine(ImmutableAverager other) {
            return new ImmutableAverager(total + other.total, count + other.count);
        }
    }

    public static double average(Stream<Double> stream) {
        return stream.reduce(new ImmutableAverager(),
                ImmutableAverager::accept,
                ImmutableAverager::combine)
                .average();
    }

    public static void main(String[] args) {
        Stream<Double> integerStream = Stream.iterate(0.1, t -> t + 1).parallel().limit(10);
        System.out.println(average(integerStream));
    }
}
