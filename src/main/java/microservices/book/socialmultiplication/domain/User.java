package microservices.book.socialmultiplication.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data

public final class User {
    private final String alias;
    protected User(){
        alias=null;
    }
}
