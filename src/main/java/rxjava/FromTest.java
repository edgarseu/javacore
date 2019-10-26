package rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * @author caozy
 * @date 2019/10/25 16:56
 */
public class FromTest {
    public static void main(String[] args) {
        Integer[] items = { 0, 1, 2, 3, 4, 5 };
        Observable myObservable = Observable.fromArray(items);

        myObservable.subscribe();
    }
}
