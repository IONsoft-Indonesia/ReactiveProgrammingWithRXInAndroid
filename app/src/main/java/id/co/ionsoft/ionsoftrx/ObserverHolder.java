package id.co.ionsoft.ionsoftrx;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * @author hendrawd on 20/07/18
 */
public class ObserverHolder {
    public static Observable<Object> observable =
            Observable.just(new Dog(), "one", "two", "three", "four", "five", new Endah())
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());
}

class Dog {
    public void ngomong() {
        Timber.d("Guk guk");
    }

    @Override
    public String toString() {
        return "Ini guguk";
    }
}

class Endah {
    public void ngomong() {
        Timber.d("Aku lagi ngomong");
    }

    @Override
    public String toString() {
        return "Aku lagi syantik";
    }
}