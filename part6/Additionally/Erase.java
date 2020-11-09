package main.ru.mephi.java.part6.Additionally;

public class Erase< T extends String> {
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    private T value;

    public static void main(String[] args) {
        Erase erase=new Erase();
   //     erase.setValue(new Object());
    }
}
