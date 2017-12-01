package emailvalidator;

public interface Effect<T> {
  void apply(T t);
}