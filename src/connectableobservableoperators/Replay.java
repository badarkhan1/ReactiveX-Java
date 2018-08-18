package connectableobservableoperators;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;

public class Replay {
    public static void main(String[] args) {
        
        // Observable.replay()
        System.out.println("Observable.replay()");

        ConnectableObservable obsrvble = Observable.empty().publish();
        
        obsrvble.replay().connect(new Action1<Subscription>(){
            @Override
            public void call(Subscription t) {
                for (int i = 11; i <= 20; i++) {
                    System.out.print(i + " ");
                }
            }
        });
    }
}
