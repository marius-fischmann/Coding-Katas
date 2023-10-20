public class Main {
    public static void main(String[] args) {
        System.out.println("hello world");
        System.out.println("hello github world");
        System.out.println("Is 42 dividable by 2? " + isDividableBy2(42));
    }

    private static boolean isDividableBy2(int number){
        return number%2==0;
    }
}
