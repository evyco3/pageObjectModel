package com.evy.tests;

import com.evy.enums.NavBarType;
import com.evy.pages.DashBoardPage;
import com.evy.pages.HomePage;
import com.evy.pages.LoginPage;
import com.evy.pages.SignupPage;
import com.github.javafaker.Faker;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class MyTests extends BaseTest{


    @Test(description = "signup with valid data & verify if signup success with valid response message from server")
    public void signupTest(){
        Faker faker=new Faker();
        SignupPage signupPage=new HomePage().getNavBar().setNavBar("Sign Up", SignupPage.class);
        String serverResponseMessage=signupPage
                .setFirstName(faker.name().firstName())
                .setSureName(faker.name().lastName())
                .setEmail(faker.internet().emailAddress())
                .setMobile(faker.phoneNumber().cellPhone())
                .setUserName(faker.name().username())
                .setPassword("a1b1c1")
                .setConfirmPassword("a1b1c1")
                .clickSubmit()
                .getServerResponseMessage();
        Assertions.assertThat(serverResponseMessage).isEqualTo("Registration Successful");
    }
    @Test(description = "login with valid data & verify login success  message with welcome message contains userName")
    public void loginTest(){
        LoginPage loginPage=new HomePage().getNavBar().setNavBar("Login", LoginPage.class);
        String welcomeMessage= loginPage.
                loginToApplication("eviTester11","a1b1c1")
                .getUserNameWelcomeMessage();
        Assertions.assertThat(welcomeMessage).contains("eviTester11");
    }
    @Test(description = "create new customer with valid data," +
            " since server do not response with proper message if customer added or not , we will check if customerName  exists from the customers table")
    public void createNewCustomerTest(){
        Faker faker=new Faker();
        LoginPage loginPage=new HomePage().getNavBar().setNavBar("Login", LoginPage.class);
        DashBoardPage dashBoardPage= loginPage.loginToApplication("eviTester11","a1b1c1");
       boolean status= dashBoardPage
                .clickOnCreateNewCustomer()
                .setName("evia")
                .setCompany(faker.company().name())
                .setAddress(faker.address().fullAddress())
                .setCity(faker.address().city())
                .setPhone(faker.phoneNumber().phoneNumber())
                .setEmail(faker.internet().emailAddress())
                .clickCreate()
               .getCustomerTablePage()
               .isCustomerNameExist("evia");
       Assertions.assertThat(status).isTrue();

    }



}
