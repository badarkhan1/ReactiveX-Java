package connectableobservableoperators;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

public class Publish {
    public static void main(String[] args) {
        
        // Observable.publish()
        System.out.println("Observable.publish()");

        Observable.just(1, 2, 3, 4, 5)
                .publish()
                .connect(new Action1<Subscription>(){
            @Override
            public void call(Subscription t) {
                if(!t.isUnsubscribed()){
                    for (int i = 1; i <= 10; i++) {
                        System.out.print(i + " ");
                    }
                    System.out.println("All items have been emitted.");
                }
            }
        });
    }
}
