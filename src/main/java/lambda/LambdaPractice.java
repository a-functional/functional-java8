package lambda;

public class LambdaPractice {

  public static void main(String[] args) {
    Executor executor = () -> System.out
        .printf("This functional interface just executes everything in func body %n");

    executor.execute();

    MathOperation operator = (a, b) -> System.out.printf("sum of %s + %s  = %s%n", a, b, a + b);
    operator.operation(20, 30);
  }

  @FunctionalInterface
  private interface Executor {
    void execute();
  }

  @FunctionalInterface
  private interface MathOperation {
    void operation(int a, int b);
  }
}
