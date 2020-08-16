package generic;

public class BoxFactory {
    public static <T extends SolidMaterial & Eatable> Box<T> makeBox(T o){
        Box<T> box = new Box<>();
        box.setValue(o);
        return box;
    }
}
