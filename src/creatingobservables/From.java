package creatingobservables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import rx.Observable;
import rx.Subscriber;


public class From {
    public static void main(String[] args){
        
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Observable.from(Iteratable<? extends T> iteratable)
        System.out.println("Observable.from(Iteratable<? extends T> iteratable)");
        Observable<Integer> obsrvble =  Observable.from(integerList);
        obsrvble.subscribe(new Subscriber<Integer>(){
            @Override
            public void onCompleted() {
                System.out.println(" All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(Integer t) {
                System.out.print(t);
            }
        });
    }
}
