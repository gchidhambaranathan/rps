package com.chidha.rps;

import com.chidha.rps.model.SchoolFeesDetails;
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
public class SchoolFeesDetailsTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void getSchoolFeesDetails () {
        SchoolFeesDetails schoolFeesDetails = this.restTemplate.getForEntity("http://localhost:"+ port + "/schooldetails/LKG", SchoolFeesDetails.class).getBody();

        assertThat(schoolFeesDetails.getStandard().equals("LKG")).isEqualTo(true);
        assertThat(schoolFeesDetails.getTerm1Fees() == 4000).isEqualTo(true);
        assertThat(schoolFeesDetails.getTerm2Fees() == 3500).isEqualTo(true);
        assertThat(schoolFeesDetails.getTerm3Fees() == 3000).isEqualTo(true);

    }

    @Test
    public void updateSchoolFeesDetails() {
        SchoolFeesDetails schoolFeesDetails = new SchoolFeesDetails();
        schoolFeesDetails.setTerm1Fees(5000);
        schoolFeesDetails.setTerm2Fees(5000);
        schoolFeesDetails.setTerm3Fees(5000);

        this.restTemplate.put("http://localhost:"+ port + "/schooldetails/LKG", schoolFeesDetails);

        schoolFeesDetails = this.restTemplate.getForEntity("http://localhost:"+ port + "/schooldetails/LKG", SchoolFeesDetails.class).getBody();

        assertThat(schoolFeesDetails.getStandard().equals("LKG")).isEqualTo(true);
        assertThat(schoolFeesDetails.getTerm1Fees() == 5000).isEqualTo(true);
        assertThat(schoolFeesDetails.getTerm2Fees() == 5000).isEqualTo(true);
        assertThat(schoolFeesDetails.getTerm3Fees() == 5000).isEqualTo(true);
    }

}
