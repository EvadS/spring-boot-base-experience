package com.example.json;

import com.example.json.model.UserRedis;
import com.example.json.repo.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SpringJsonBaseApplication.class)

@SpringBootTest(classes = SpringJsonBaseApplication.class)
//@TestPropertySource(locations = "classpath:application.yaml")
public class ItemIntegrationTest {

    @Autowired
    private UserRepository itemRepository;

    @Test
    public void shouldNotAllowToPersistNullItemsPrice() {
        assertThatThrownBy(() -> itemRepository.save(new UserRedis()))
                .hasRootCauseInstanceOf(ConstraintViolationException.class)
                .hasStackTraceContaining("must not be null");
    }
}