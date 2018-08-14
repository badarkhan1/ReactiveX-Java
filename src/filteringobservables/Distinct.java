package filteringobservables;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;

public class Distinct {
    public static void main(String[] args) {
        
        // Observable.distict()
        System.out.println("Observable.distinct()");
        Observable.from(new Integer[]{0,1,2,3,0,1,3,6,4,6,2,5,7,8,7,9,0,9})
                .distinct()
                .subscribe(new Subscriber<Integer>(){
            @Override
            public void onCompleted() {
                System.out.println("All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(Integer t) {
                System.out.print(t + " ");
            }
        });
    }
}
