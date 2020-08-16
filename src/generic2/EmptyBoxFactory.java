package generic2;

public class EmptyBoxFactory {
    public static <T> Box<T> makeBox(){
        return new Box<>();
    }
}
