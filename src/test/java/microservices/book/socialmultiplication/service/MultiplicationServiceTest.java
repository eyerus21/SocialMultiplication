package microservices.book.socialmultiplication.service;

import microservices.book.socialmultiplication.domain.Multiplication;
import microservices.book.socialmultiplication.domain.MultiplicationResultAttempt;
import microservices.book.socialmultiplication.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiplicationServiceTest {
    private MultiplicationServiceImpl multiplicationServiceImpl;
    @Mock
    private RandomGeneratorService randomGeneratorService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        multiplicationServiceImpl =new MultiplicationServiceImpl(randomGeneratorService);
    }



    @Test
    public void createRandomMultiplicationTest(){
        //given or mocked random generator service will return first 50 then 30
       given(randomGeneratorService.generateRandomFactor()).willReturn(50,30);

        //when
        Multiplication multiplication=multiplicationServiceImpl.createRandomMultiplication();

        //then
        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);
        //assertThat(multiplication.getResult()).isEqualTo(1500);
    }

    @Test
    public void checkCorrectAttemptTest(){
        //given
        Multiplication multiplication= new Multiplication(50,60);
        User user= new User("john");
        MultiplicationResultAttempt attempt= new MultiplicationResultAttempt(user,multiplication,3000);

        //when
        boolean attemptResult= multiplicationServiceImpl.checkAttempt(attempt);

        //assert
        assertThat(attemptResult).isTrue();
    }

    @Test
    public void checkWrongAttemptTest(){

        //given
        Multiplication multiplication= new Multiplication(50,60);
        User user= new User("john");
        MultiplicationResultAttempt attempt= new MultiplicationResultAttempt(user,multiplication,3001);

        //when
        boolean attemptResult= multiplicationServiceImpl.checkAttempt(attempt);

        //assert
        assertThat(attemptResult).isFalse();

    }

}
