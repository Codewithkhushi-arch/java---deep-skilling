class Logger {
    private static Logger instance;
    private Logger() {}
    public static Logger getInstance() {
        if(instance == null) instance = new Logger();
        return instance;
    }
    public void log(String msg) { System.out.println("Log: " + msg); }
}
public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();
        System.out.println("Are both instances same? " + (l1 == l2));
        l1.log("Singleton Pattern Test");
    }
}

/*
Output:
Are both instances same? true
Log: Singleton Pattern Test
*/
