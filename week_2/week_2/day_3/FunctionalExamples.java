package week_2.day_3;

import week_2.day_3.dto.Address;
import week_2.day_3.dto.City;
import week_2.day_3.dto.User;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalExamples {

    //Composition
    Predicate<Integer> startPredicate = e -> e > 18;
    Predicate<Integer> compositionPredicate = startPredicate
            .and(e -> e <= 100)
            .or(e -> e == 42);


    //Currying
    Supplier<Function<String, Integer>> carryingPredicateFunction = () -> Integer::valueOf;
    Supplier<Predicate<Integer>> carryingPredicateSupplier = () -> i -> i != 0;

    //Monad
    User user = new User(new Address(new City("Chicago")));

    Optional<String> monadCityName = Optional.of(user)
            .map(User::getAddress)
            .map(Address::getCity)
            .map(City::getName);

}
