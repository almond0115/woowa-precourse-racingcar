package racingcar.model;

import racingcar.model.car.Car;
import racingcar.validation.RacerValidator;
import racingcar.validation.Validator;

import java.util.Arrays;
import java.util.List;

public class Racer {
    public static final String SEPERATOR = ",";
    private final List<Car> racer;
    public Racer(String name) {
        validate(name);
        this.racer = Arrays.stream(name.split(SEPERATOR))
                .map(Car::new)
                .toList();
    }

    public void play(){
        racer.forEach(Car::move);
    }

    private void validate(String value){
        Validator validator = new RacerValidator();
        validator.validate(value);
    }

//    public String getWinner() {
//        Car winner = racer.stream().max(Car::compareTo).orElseThrow();
//
//        return racer.stream()
//                .filter(winner::equals)
//                .map(Car::getName)
//                .collect(Collectors.joining(SEPERATOR));
//    }

    public List<Car> getWinner() {
        Car first = racer.stream()
                .max(Car::compareTo)
                .orElseThrow(IllegalAccessError::new);

        return racer.stream()
                .filter(car -> car.equals(first))
                .toList();
    }

    public String winnerToString() {
        List<String> winner = getWinner()
                .stream()
                .map(Car::getName)
                .toList();

        return String.join(SEPERATOR, winner);

//        List<Car> winner = getWinner();
//        StringBuilder stringBuilder = new StringBuilder();
//        for (Car car : winner){
//            stringBuilder.append(car.getName()).append(",");
//        }
//        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//        return stringBuilder.toString();
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : racer){
            stringBuilder.append(car.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if (!(obj instanceof Racer target)){
            return false;
        }

        return racer.equals(target.racer);
    }

//    private void validate(String name){
//        validateSize(name);
//    }
//
//    private void validateSize(String value){
//        if (value == null || value.split(SEPERATOR).length == 0){
//            throw new IllegalArgumentException("참가자 없음");
//        }
//    }
}
