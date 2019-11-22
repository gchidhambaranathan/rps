package com.chidha.rps;


import com.chidha.rps.model.SchoolAddress;
import com.chidha.rps.model.SchoolProfile;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SchoolProfileHttpTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test

    public void getSchoolProfileTest() {


        SchoolProfile schoolProfile = this.restTemplate.getForEntity("http://localhost:"+ port + "/schoolprofile/rps", SchoolProfile.class).getBody();


        assertThat(schoolProfile.getSchoolId().equals("rps")).isEqualTo(true);
        assertThat(schoolProfile.getSchoolRegId().equals("REG:1234")).isEqualTo(true);
        assertThat(schoolProfile.getEmail().equals("rps@gmail.com")).isEqualTo(true);
        assertThat(schoolProfile.getPhoneNumber().equals("04373-274333")).isEqualTo(true);
        assertThat(schoolProfile.getSchoolAddress().getStreet().equals("Palliodavayal, Navakkollai, Naidum(post), Pattukkottai")).isEqualTo(true);
        assertThat(schoolProfile.getSchoolAddress().getPincode() == 614802).isEqualTo(true);

    }

    @Test

    public void updateSchoolProfileTest() {
        SchoolProfile schoolProfile = new SchoolProfile();
        SchoolAddress schoolAddress = new SchoolAddress();

        schoolProfile.setSchoolRegId("REG:12346666");
        schoolProfile.setEmail("rps123@gmail.com");
        schoolProfile.setPhoneNumber("9489488754");

        schoolAddress.setStreet("1st street, Nadium");
        schoolAddress.setPincode(111222);
        schoolProfile.setSchoolAddress(schoolAddress);

        this.restTemplate.put("http://localhost:"+ port + "/schoolprofile/rps",schoolProfile);

        schoolProfile = this.restTemplate.getForEntity("http://localhost:"+ port + "/schoolprofile/rps", SchoolProfile.class).getBody();


        assertThat(schoolProfile.getSchoolId().equals("rps")).isEqualTo(true);
        assertThat(schoolProfile.getSchoolRegId().equals("REG:12346666")).isEqualTo(true);
        assertThat(schoolProfile.getEmail().equals("rps123@gmail.com")).isEqualTo(true);
        assertThat(schoolProfile.getPhoneNumber().equals("9489488754")).isEqualTo(true);
        assertThat(schoolProfile.getSchoolAddress().getStreet().equals("1st street, Nadium")).isEqualTo(true);
        assertThat(schoolProfile.getSchoolAddress().getPincode() == 111222).isEqualTo(true);
    }


}
