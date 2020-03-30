package singleton;

public class MySingleton {

    private MySingleton instance;

    private MySingleton() {
    }

    //Normal Singleton
    public MySingleton getNaiveInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }

    //Synchronized to avoid issues
    public synchronized MySingleton getSyncInstance() {
        if (instance == null) {
            instance = new MySingleton();
        }
        return instance;
    }

    //Double checking to avoid synchronization issues.
    public MySingleton getInstance() {
        if (instance == null) {
            synchronized (MySingleton.class) {
                if (instance == null) {
                    instance = new MySingleton();
                }
            }
        }
        return instance;
    }

}
