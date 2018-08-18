package observableutilityoperators;

import rx.Observable;
import rx.Subscriber;

public class TimeStamp {
    public static void main(String[] args) {
        
        // Observable.timeStamp()
        System.out.println("Observable.timeStamp()");

        // There seems to be something wrong.
//        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
//                .timestamp()
//                .subscribe(new Subscriber<TimeStamped<Integer>>(){
//            @Override
//            public void onCompleted() {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void onError(Throwable thrwbl) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//
//            @Override
//            public void onNext(<any> t) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
    }
}
