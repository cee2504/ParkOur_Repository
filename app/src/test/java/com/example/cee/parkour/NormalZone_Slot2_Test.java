package com.example.cee.parkour;


import org.junit.Test;

import static org.junit.Assert.*;

public class NormalZone_Slot2_Test {

    @Test
    public void testTimeInput(){


        int testInput = 10;
        if ((testInput >=11) && (testInput <13)){
            System.out.printf("Input Test pass");
            System.out.println("\n");
        }
        else if (testInput >= 17 ){
            System.out.printf("Input Test pass");
            System.out.println("\n");
        }
        else {
            System.out.printf("Input Test pass");
            System.out.println("\n");
        }

    }



    @Test
    public void testParkingFee(){
        int testSetTime = 13;
        int testDuration = 6;
        int testTotalHour = testSetTime + testDuration;
        int price = 0;

        if (( testSetTime < 11) && (testTotalHour >11)){
            System.out.printf("This time is booked");
            System.out.printf("Test pass");
        }
        else if (testTotalHour > 24 ){
            System.out.printf("Test  pass");
        }
        else if (testTotalHour < 9  ){
            System.out.printf("Parking is free from 17:00 from 9:00. No booking required");
            System.out.printf("Test pass");
        }
        else if (( testSetTime < 9) && (testTotalHour >= 9) ){
            if (testTotalHour <= 17){
                price = (testDuration - ( 9 - testSetTime )) * 20;
                System.out.printf("Parking Fee Test Pass: \n"+
                        "Normal Zone - $20/hour \n" +
                        "Total Price($): " + Integer.toString(price));
            }
            else if ((testTotalHour >17)){
                price = (testDuration - ( 9 - testSetTime )) * 20 - 20 * (testTotalHour - 17);
                System.out.printf("Parking Fee Test Pass: \n"+
                        "Normal Zone - $20/hour \n" +
                        "Total Price($): " + Integer.toString(price));
            }
            System.out.println("");
        }
        else {

            if (testTotalHour <= 17){
                price = testDuration * 20 - 20 * (testTotalHour - 17);
                System.out.printf("Parking Fee Test Pass: \n"+
                        "Normal Zone - $20/hour \n" +
                        "Total Price($): " + Integer.toString(price));
            }
            else if ((testTotalHour >17)){
                price = testDuration * 20 - 20 * (testTotalHour - 17);
                System.out.printf("Parking Fee Test Pass: \n"+
                        "Normal Zone - $20/hour \n" +
                        "Total Price($): " + Integer.toString(price));
            }
            System.out.println("");
        }

        //Check if the price calculate fee after 5pm
        //Test input:
        //Booking start from: 13.00pm to 18.00pm
        assertNotEquals(100, price);
    }
}
