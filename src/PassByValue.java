public class PassByValue{
    public static void main(String[] args) {

        int value = 10;

        System.out.println("Value before: " + value);
        changeVal(value);
        System.out.println("Value after: " + value);
    }

    public static void changeVal(int val) {
    val = 100;
    }
}
