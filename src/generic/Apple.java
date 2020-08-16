package generic;

public class Apple extends SolidMaterial implements Eatable{

    public Apple(int size, int weight) {
        super(size, weight);
    }

    public Apple() {
        super(10,10);
    }

    @Override
    public void eating() {
        System.out.println("How tasty apple is!");
    }

    @Override
    public String toString(){
        return "tasty apple";
    }
}
