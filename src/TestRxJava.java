import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.List;


public class TestRxJava {



    public static void main(String[] args) {

//        Observable.just("Hello,RxJava")
//                .map(s->s.hashCode())
//                .map(s->Integer.toString(s))
//                .subscribe(s -> System.out.println(s));

        List<String> urls = new ArrayList<String>();
        urls.add("WWW.baidu.com");
        urls.add("WWW.google.com");
        urls.add("WWW.yahoo.com");

//        query("Hello, world!")
//                .subscribe(urls -> {
//                    Observable.from(urls)
//                            .subscribe(url -> System.out.println(url));
//                });

//        Observable.from(urls)
//                 .subscribe(url -> System.out.println(url));

//        query("Hello, world!")
//                .subscribe(urls -> {
//                    Observable.from(urls)
//                            .subscribe(url -> System.out.println(url));
//                });

        query("Hello, world!")
                .flatMap(url -> Observable.from(urls))
                .subscribe(url -> System.out.println(url));
    }

    private static Observable<Object> query(String s) {
        return Observable.just(s);
    }
}
