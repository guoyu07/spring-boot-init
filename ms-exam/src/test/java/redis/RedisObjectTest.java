package redis;

import com.kyee.domain.Exam;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class RedisObjectTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedisObject(){
        Exam exam_one = Exam.builder().examId(1L).examName("test one Exam").build();
        redisTemplate.opsForValue().set(exam_one.getExamName(), exam_one);
        Exam exam_two = Exam.builder().examId(2L).examName("test two Exam").build();
        redisTemplate.opsForValue().set(exam_two.getExamName(), exam_two);
        Exam exam_three = Exam.builder().examId(3L).examName("test three Exam").build();
        redisTemplate.opsForValue().set(exam_three.getExamName(), exam_three);

        Assert.assertEquals("test one Exam", ((Exam)redisTemplate.opsForValue().get("test one Exam")).getExamName());
        Assert.assertEquals("test two Exam", ((Exam)redisTemplate.opsForValue().get("test two Exam")).getExamName());
        Assert.assertEquals("test three Exam", ((Exam)redisTemplate.opsForValue().get("test three Exam")).getExamName());
    }
}
