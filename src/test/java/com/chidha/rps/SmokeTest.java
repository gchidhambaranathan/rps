package com.chidha.rps;


import com.chidha.rps.controller.PaymentController;
import com.chidha.rps.controller.SchoolFeesDetailsController;
import com.chidha.rps.controller.SchoolProfileController;
import com.chidha.rps.controller.StudentController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    @Autowired
    private SchoolProfileController schoolProfileController;

    @Autowired
    private SchoolFeesDetailsController schoolFeesDetailsController;


    @Autowired
    private StudentController studentController;


    @Autowired
    private PaymentController paymentController;

    @Test
    public void contexLoads() throws Exception {
        assertThat(schoolProfileController).isNotNull();
        assertThat(schoolFeesDetailsController).isNotNull();
        assertThat(studentController).isNotNull();
        assertThat(paymentController).isNotNull();
    }
}
