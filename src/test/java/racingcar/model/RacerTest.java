package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacerTest {
    @DisplayName("참가자가 없는 경우 예외 발생")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    void checkRacer(String value){
        assertThatThrownBy(() -> new Racer(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}