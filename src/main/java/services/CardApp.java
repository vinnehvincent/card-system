package services;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class CardApp extends Application {
    private Set<Object> singletons = new HashSet<>();
    public CardApp(){
        singletons.add(new Cards());
        singletons.add(new Cardholders());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
