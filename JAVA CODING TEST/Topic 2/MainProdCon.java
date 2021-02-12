public class MainProdCon {
    public static void main(String[] args) throws InterruptedException {
        final Food food = new Food();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    food.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    food.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
