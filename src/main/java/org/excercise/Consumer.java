package org.excercise;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Consumer {

    LinkedList<NumberData> storage = new LinkedList<>();

    public void accept(int number) {
        NumberData numberData = new NumberData();
        numberData.setNumber(number);
        numberData.setDate(new Date());
        storage.addFirst(numberData);
    }

    public Double mean() {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.MINUTE, -5);
        now = cal.getTime();
        Date finalDate = now;
        return storage.stream()
                .takeWhile(v -> v.getDate().getTime() > finalDate.getTime())
                .mapToInt(NumberData::getNumber)
                .average().orElse(0);
    }

    public List<Integer> show() {
        return storage.stream().map(NumberData::getNumber).toList();
    }

}
