package com.vlc2.academy.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// Before running the application perform the following steps:
// 1) Run the script resources.templates.library.script_db_library_reset.sql on your mysql database
// 2) Run the script resources.templates.library.populate_db_library.sql on your mysql database
// 3) Change the application.properties file so that it's synchronized to your database
// 4) The first time you run the application change the value on the application.properties file of
// populate = true. Then, run the application and perform one time the get request on the endpoint /populating on the populating controller.
// This operation will generate plenty of random values for sales and orders in the timespan from 9 months ago to 3 months from now
// and populate the database as such.
// Be aware that this method should be only called once, you can set the value of populate as false once you performed this operation.


@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {


        SpringApplication.run(LibraryApplication.class, args);}

}
