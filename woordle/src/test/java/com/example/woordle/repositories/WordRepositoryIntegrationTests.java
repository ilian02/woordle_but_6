package com.example.woordle.repositories;

import com.example.woordle.TestDataUtil;
import com.example.woordle.domain.Word;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class WordRepositoryIntegrationTests {

    private WordsRepository underTest;

    @Autowired
    public WordRepositoryIntegrationTests(WordsRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatWordCanBeCreatedAndRecalled() {
        Word word = TestDataUtil.getTestWordA();
        underTest.save(word);
        Optional<Word> result = underTest.findById(word.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(word);
    }

}
