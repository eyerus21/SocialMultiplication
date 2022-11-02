package microservices.book.socialmultiplication.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;



@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomGeneratorServiceTest {

    private RandomGeneratorServiceImpl randomGeneratorServiceImpl;

   @Before
   public void setUp(){
       randomGeneratorServiceImpl = new RandomGeneratorServiceImpl();
   }

    @Test
    public void generateRandomFactorIsBetweenExpectedLimits() throws Exception{
        //when a good sample of randomly generated factors is generated
        List<Integer> randomFactors= IntStream.range(0, 1000)
                .map(i -> randomGeneratorServiceImpl.generateRandomFactor())
                .boxed().toList();

        // because we want a middle-complexity calculation
        assertThat(randomFactors).isSubsetOf(IntStream.range(11, 100)
                .boxed().collect(Collectors.toList()));
    }


}
