public class SuperClassTest {
    public static void main(String[] args) throws Exception {
        Class i = Integer.class;
        Class n = i.getSuperclass();
        System.out.println(n);
        Class o = n.getSuperclass();
        Class m = Class.forName("java.lang.Class");
        System.out.println(o);
        System.out.println(m);
        System.out.println(o.getSuperclass());
    }
}