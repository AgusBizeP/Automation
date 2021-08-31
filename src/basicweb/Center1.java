package basicweb;

import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebElement;

public class Center1 {
    
    private WebDriver driver;
    private String baseURL;


    @Before
    
    //Go to http://qa-test-v1.s3-website-ap-southeast-2.amazonaws.com/
    public void SetUp() throws Exception {
    	//System.setProperty("webdriver.chrome.driver", "../../Drivers/chromedriver");
        baseURL = "http://qa-test-v1.s3-website-ap-southeast-2.amazonaws.com/";
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseURL);

    }

 //Test Case number 1,2,3 - Empty fields
    @Test
    public void testCase1() {
     
       // click on Submit button

        driver.findElement(By.className("is-link")).click();

        
        //validate errors

        String expectedEmailError = "Please enter email address";
        String expectedPasswordError = "This field is required";
        String expectedPasswordConfError = "This field is required";
        
        
        String emailError = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[1]/p")).getText();

        if (emailError.contentEquals(expectedEmailError)){
            System.out.println("Email error message --> PASSED");
        }
        else {
            System.out.println("Email error message --> FAILED");
        }


        String forenameError = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[2]/p")).getText();

        if (forenameError.contentEquals(expectedPasswordError)){
            System.out.println("Password error message --> PASSED");
        }
        else {
            System.out.println("Password error message --> FAILED");
        }


        String messageError = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[3]/p")).getText();

        if (messageError.contentEquals(expectedPasswordConfError)){
            System.out.println("'Please confirm password' error message --> PASSED");
        }
        else {
            System.out.println("'Please confirm password' error message --> FAILED");
        }
    }



   //test Case 11 - Sign up - "Email",  "Password" and "Please confirm password" -  login successful
   @Test
    public void testCase2() {
       
	  String expectedMsgSuccessful = "Business details";
	   
	   //Populate fields

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[1]/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[1]/div/input")).sendKeys("agusbize25@email");


        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[2]/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[2]/div/input")).sendKeys("Martes");

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[3]/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[3]/div/input")).sendKeys("Martes");


        // click on Submit button

        driver.findElement(By.className("is-link")).click();

        //Validate Successful submission message
       
    
        String messageValidation = driver.findElement(By.className("title")).getText();

        if (messageValidation.contentEquals(expectedMsgSuccessful)){
            System.out.println("Test Case 2 --> PASSED");
        }
        else {
            System.out.println("Test Case 2 --> FAILED");
        }
    }

   
   
   //Test Cases 12  Empty Required fields company
    @Test
    public void testCase3() {

  	   //Populate fields

          driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[1]/div/input")).click();
          driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[1]/div/input")).sendKeys("agusbize25@email");


          driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[2]/div/input")).click();
          driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[2]/div/input")).sendKeys("Martes");

          driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[3]/div/input")).click();
          driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[3]/div/input")).sendKeys("Martes");


          // click on Submit button

          driver.findElement(By.className("is-link")).click();

          //Validate Successful submission message
          String expectedMsgSuccessful = "Business details";
      
          String messageValidation = driver.findElement(By.className("title")).getText();

          if (messageValidation.contentEquals(expectedMsgSuccessful)){
              System.out.println("Test Case 2 --> PASSED");
          }
          else {
              System.out.println("Test Case 2 --> FAILED");
          }
          
          //Validate error in Company
          driver.findElement(By.className("is-link")).click();
          
          ArrayList<WebElement> errorMessages = (ArrayList<WebElement>) driver.findElements(By.className("help"));
	      boolean isDisplayed = false;
	      int size = errorMessages.size();
	      System.out.println("Size of the list: " + size);
	      for(int i=0; i<size; i++) {
	      isDisplayed = errorMessages.get(i).isSelected();

	      }
	      
	      int expectedErrorMessages = 4;
	      int actualErrorMessages = size;
	      
	      if (actualErrorMessages==expectedErrorMessages){
              System.out.println("Test Case 3 --> PASSED");
          }
          else {
              System.out.println("Test Case 3 --> FAILED");
              
          }
    
	      
          
    }
    	//Test Case 26 - Terms & Conditions - Click on Submit agreeing  to conditions
   @Test
    public void testCase4() {

       
	   driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[1]/div/input")).click();
       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[1]/div/input")).sendKeys("agusbize25@email");


       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[2]/div/input")).click();
       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[2]/div/input")).sendKeys("Martes");

       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[3]/div/input")).click();
       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[3]/div/input")).sendKeys("Martes");


       // click on Submit button

       driver.findElement(By.className("is-link")).click();

       //Validate Successful submission message
       String expectedMsgSuccessful = "Business details";
   
       String messageValidation = driver.findElement(By.className("title")).getText();

       if (messageValidation.contentEquals(expectedMsgSuccessful)){
           System.out.println("submission message --> PASSED");
       }
       else {
           System.out.println("submission message --> FAILED");
       }
		 
     //Populate fields
       
       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/div[1]/div/input")).click();
       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("Matilda");


       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/div[2]/div/input")).click();
       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("53 Blockhouse Bay");

       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/div[3]/div/input")).click();
       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/div[3]/div/input")).sendKeys("0277660056");
       
       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/div[4]/div/input")).click();
       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/div[4]/div/input")).sendKeys("100");
       
       // click on Next
       driver.findElement(By.className("is-link")).click();
       

       // click on Next
       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[6]/button[2]")).click();
       
       // Check box
       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[1]/div/label/input")).click();
       //click on Submit
       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/button[2]")).click();
       
   		 
   
	   String expectedCompleteSuccessful = "Completed";
	   
	   String messageValidation1 = driver.findElement(By.className("title")).getText();
	
	   if (messageValidation1.contentEquals(expectedCompleteSuccessful)){
	       System.out.println("Test Case 4 --> PASSED");
	   }
	   else {
	       System.out.println("Test Case 4 --> FAILED");
	   }
   		
} 

       // validate error messages disappear when completing fields
       @Test 
 
       public void testCase5() {
    	 //Populate fields

           driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[1]/div/input")).click();
           driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[1]/div/input")).sendKeys("agusbize25@email");


           driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[2]/div/input")).click();
           driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[2]/div/input")).sendKeys("Martes");

           driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[3]/div/input")).click();
           driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/form/div[3]/div/input")).sendKeys("Martes");


           // click on Submit button

           driver.findElement(By.className("is-link")).click();

           //Validate Successful submission message
           String expectedMsgSuccessful = "Business details";
       
           String messageValidation = driver.findElement(By.className("title")).getText();

           if (messageValidation.contentEquals(expectedMsgSuccessful)){
               System.out.println("submission message --> PASSED");
           }
           else {
               System.out.println("submission message --> FAILED");
           }
           
           //Validate error in Company
           driver.findElement(By.className("is-link")).click();
           
           ArrayList<WebElement> errorMessages = (ArrayList<WebElement>) driver.findElements(By.className("help"));
 	      boolean isDisplayed = false;
 	      int size = errorMessages.size();
 	      System.out.println("Size of the list: " + size);
 	      for(int i=0; i<size; i++) {
 	      isDisplayed = errorMessages.get(i).isSelected();

 	      }
 	     int expectedErrorMessages1 = 4;
	      int actualErrorMessages1 = size;
	      
	      if (actualErrorMessages1==expectedErrorMessages1){
             System.out.println(" validate error  --> PASSED");
         }
         else {
             System.out.println("validate errorss  --> FAILED");
             
         }
 	      
 	   //Populate fields
 	       
 	       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/div[1]/div/input")).click();
 	       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/div[1]/div/input")).sendKeys("Matilda");


 	       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/div[2]/div/input")).click();
 	       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/div[2]/div/input")).sendKeys("53 Blockhouse Bay");

 	       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/div[3]/div/input")).click();
 	       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/div[3]/div/input")).sendKeys("0277660056");
 	       
 	       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/div[4]/div/input")).click();
 	       driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[2]/div[4]/div/input")).sendKeys("100");
 	      
 	      
           
       //validate errors are gone

	      
 	      ArrayList<WebElement> errorMessages1 = (ArrayList<WebElement>) driver.findElements(By.className("help"));
	      boolean isDisplayed1 = false;
	      int size1 = errorMessages1.size();
	      System.out.println("Size of the list: " + size1);
	      for(int i=0; i<size1; i++) {
	      isDisplayed1 = errorMessages1.get(i).isSelected();

	      }
	      int expectedErrorMessages2 = 0;
	      int actualErrorMessages2 = size;
	      
	      if (actualErrorMessages2==expectedErrorMessages2){
              System.out.println("Test Case 5 --> PASSED");
          }
          else {
              System.out.println("Test Case 5 --> FAILED");
              
          }
}
}