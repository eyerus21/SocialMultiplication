package microservices.book.socialmultiplication.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public final class MultiplicationResultAttempt {

  private final User user;
  private final Multiplication multiplication;
  private final int resultAttempt;

  MultiplicationResultAttempt(){
      user=null;
      multiplication=null;
      resultAttempt=-1;
  }
}

