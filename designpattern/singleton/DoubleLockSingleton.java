public class DoubleLockSingleton {
    private static DoubleLockSingleton instance = null;

    public void methodA() {
        System.out.println(this.getClass());
    }

    public static DoubleLockSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleLockSingleton.class) {
                if (instance == null) {
                    instance = new DoubleLockSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        getInstance().methodA();
    }
}