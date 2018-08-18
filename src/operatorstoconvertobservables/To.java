package operatorstoconvertobservables;

import java.util.List;
import java.util.ListIterator;
import rx.Observable;
import rx.Subscriber;

public class To {
    public static void main(String[] args) {
        
        // Observable.toList()
        System.out.println("Observable.toList()");

        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .toList()
                .subscribe(new Subscriber<List<Integer>>(){
            @Override
            public void onCompleted() {
                System.out.println("All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(List<Integer> t) {
                ListIterator<Integer> iterator = t.listIterator();
                while(iterator.hasNext()){
                    System.out.print(iterator.next() + " ");
                }
            }
        });
    }
}
