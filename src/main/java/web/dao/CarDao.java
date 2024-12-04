package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class CarDao {
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("BMW", 2005, "Red"));
        cars.add(new Car("AUDI", 2001, "White"));
        cars.add(new Car("PORCHE", 1999, "Black"));
        cars.add(new Car("LADA", 2002, "Yellow"));
        cars.add(new Car("LADA", 2009, "Purple"));
    }

    public List<Car> getCarsByNumber(int count) {
        return IntStream.range(0, cars.size())
                .filter(l -> l < count)
                .mapToObj(cars::get)
                .toList();
    }
}
