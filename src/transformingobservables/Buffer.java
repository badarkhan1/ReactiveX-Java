package transformingobservables;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func0;


public class Buffer {
    public static void main(String[] args){
        
        // Observable.buffer(int count)
        System.out.println("Observable.buffer(int count)");
        Observable<Integer> obsrvble = Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        obsrvble.buffer(3)
            .subscribe(new Subscriber<List<Integer>>() {
                @Override
                public void onCompleted() {
                    System.out.println("All items have been emitted!");
                }

                @Override
                public void onError(Throwable thrwbl) {
                    System.out.println("Something went wrong...");
                }

                @Override
                public void onNext(List<Integer> t) {
                    Iterator<Integer> iterator = t.iterator();
                    while (iterator.hasNext()) {
                        System.out.print(iterator.next() + " ");
                    }
                    System.out.println();
                }
        });
    }
}
