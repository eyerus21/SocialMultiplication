package microservices.book.socialmultiplication.domain;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public final class Multiplication {
    private final int factorA;
    private final int factorB;
    //private int result;


    public Multiplication() {
        this(0,0);
    }
}
