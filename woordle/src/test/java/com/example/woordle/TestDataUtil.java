package com.example.woordle;

import com.example.woordle.domain.Word;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

public class TestDataUtil {

    public static Word getTestWordA() {
        return Word.builder().word("woords").date(LocalDate.of(2000, 1, 1)).build();
    }
}
