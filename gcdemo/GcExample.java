public class GcExample {
    private static class E {
        public static final int[] a = new int[1024 * 10];
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        while (true) {
            new E();
        }
    }
}