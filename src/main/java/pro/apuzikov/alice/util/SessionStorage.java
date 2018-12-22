package pro.apuzikov.alice.util;


import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class SessionStorage {
    private final static long CLEAN_MILLIS = 10000000L;
    private final ConcurrentHashMap<String, CacheInfo> cache = new ConcurrentHashMap<>();
    private final Date creationDate;

    public SessionStorage() {
        creationDate = new Date();
    }

    public void put(String key, Object value) {
        cache.put(key, new CacheInfo<>(value));
        cleanUp();
    }

    public Object get(String key) {
        return cache.get(key).getValue();
    }

    //Todo: normal cache for sessions
    public void cleanUp() {
        if (new Date().getTime() - creationDate.getTime() > CLEAN_MILLIS) {
            creationDate.setTime(new Date().getTime());
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.add(-1, Calendar.HOUR);
            for (Map.Entry<String, CacheInfo> entry : cache.entrySet()) {
                if (entry.getValue().getDate().before(calendar.getTime())) {
                    cache.remove(entry.getKey());
                }
            }
        }
    }

    private static class CacheInfo<T> {
        Date date;
        T value;

        public CacheInfo(T value) {
            this.date = new Date();
            this.value = value;
        }

        public Date getDate() {
            return date;
        }

        public T getValue() {
            return value;
        }
    }
}
