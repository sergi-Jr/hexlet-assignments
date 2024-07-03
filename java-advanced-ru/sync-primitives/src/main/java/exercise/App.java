package exercise;

class App {

    public static void main(String[] args) {
        // BEGIN
        var sl = new SafetyList();

        var t1 = new Thread(new ListThread(sl));
        var t2 = new Thread(new ListThread(sl));

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sl.getSize());
        // END
    }
}

