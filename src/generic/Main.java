package generic;

public class Main {
    public static void main(String[] args){
        Cube cube = new Cube(4);
        Water water = new Water(4,17);
        Apple apple = new Apple();

        //Box<Apple> box = new Box<>(apple);
        Box<Apple> box = BoxFactory.makeBox(apple);

        //cube는 eatable을 구현하지 않음.
        //Box<Cube> box = new Box<>(cube);
        //water는 eatable을 구현하지도, solidmarerial도 상속하지 않음.
        //Box<Water> box1 = new Box<Water>(water);

        System.out.println(box);


    }
}
