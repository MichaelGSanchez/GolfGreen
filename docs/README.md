# Cohort 6: Stand Alone Project

## Documentation

**App Name**

*GolfGreen*, "Saving You Green Before You Hit The Green"

**App Overview**

As a an avid golfer, I find that it can be very difficult to easily
look up course information and pricing.  This app was designed to simplify
golf greens fees by simply displaying them through a quick search of the location.

The application was a great learning process for myself and still had unimplemented
features that I would like to add in.  The app consumed the following services to help
build the app:

* Fragment management
* Nav drawer demonstration
* Basic <code>RecyclerView</code>  implementation 
* CSV Parsing, and use of CSV file for a builtin database
* <code>.XML</code> formatting 
* Google sign-in 

**Current State of Completion and Readiness**

The current state of *GolfGreen* is an app that allows you to search three of 
the four largest cities in New Mexico. The available locations are Albuquerque, 
Santa Fe, and Las Cruces. Upon searching the desired location, the app displays 
the course name, the price of the green fees, and course phone number. Based on the
functionality and layout of the app, the app only has one orientation, and that 
is in its portrait mode. Prior to starting the app, you will need to sign in 
with a valid google account. 

**Testing**

* *GolfGreen* was tested on a [Motorola G6, Android API 26.](https://www.motorola.com/us/products/moto-g-gen-6)
The issues observed on this device was the formatting of the background image on
the app during the use of <code>RecyclerView</code>.  A second error is within 
the "User Settings" of the app. If the "User Settings" fragment is the most recent
fragment selected, you can still type on it from the current fragment you are in. 
  
* Test classes for its database and functionality were created, however still need
more to be fully implemented. 

* Due to PC limitations the app was not tested on an emulator. 

**Design & Technical Documentation**

* [JavaDoc](api/)
* [DDL](ddl.md)
* [Wireframe of App](GolfGreenWireFrame.png)
* [ERD of GolfGreen](GolfGreenErd.pdf)
* [SQL Table's](SQLTables.md)


**User Stories**

* User Story 1, The Avid Golfer
    
   Avid golfers are very committed to the game and will go to any length to play. 
   Some of these avid golfers will play no matter what the weather is, or where 
   they are.  However, these avid golfers typically have to search in many outdated
   websites to check prices, book tee times, find out the level of difficulty, or 
   just find a number to the golf course.  Often, these golfers know most of the prices
   and info round their own town.  However, these golfers are known to want to play
   in other cities.  In their case, it would be very useful to not have to check 
   multiple sites, but rather have all of the information they are looking for stored in
   one place.  This is where the GolfGreen app comes into play. These avid golfers could 
   explore course around the world and have the info that they need.  If GolfGreen wanted 
   to take it a step further, the app could even send info to these users (should the users
   opt in to receive deals) about golf deals in their area or around the world! 

* User Story 2, The Beginning Golfer

   The beauty of GolfGreen, is it has the capacity to reach many different users. 
   This also includes beginning golfers! As a beginning golfer, it can be very intimidating
   to want to give the game a try.  However, GolfGreen will not only show the 
   green fees, location and pricing, it will also rate the golf courses difficulty. For a beginner,
   that is a very helpful hint and helps take away the intimidation factor. 
   Housing everything in one central location is helpful for all! 

**List of 3rd Party Libraries**

  * [Facebook Stetho](https://github.com/facebook/stetho)
    implementation 'com.facebook.stetho:stetho:1.5.0'
    
    This was used to check the data being passed between the CSV database
    and the app that was eventually read when searched. 
    
  * [Google Play SignIn](https://developers.google.com/android/guides/releases) 
    implementation 'com.google.android.gms:play-services-auth:16.0.1' 
    
    To utilize Google signIn
    
  * [Apache Commons](https://commons.apache.org/proper/commons-csv/)
   implementation 'org.apache.commons:commons-csv:1.6'
   
   Used to parse CSV files created in the database.
      

**Copyrights and Licenses**
 Copyright 2019 Michael Sanchez
 Licensed under the Apache License, Version 2.0;
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at:
 
 <a href= "http://www.apache.org/licenses/LICENSE-2.0">http://www.apache.org/licenses/LICENSE-2.0</a>
 
 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 AS IS BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 either express or implied. See the License for the specific language governing
 permissions and limitations under the License.

**Build Instructions**
Step 1 - [Clone Git Repository](https://github.com/michaelgsanchez/golfgreen)

Step 2 - When creating a new project clone the project from the cloned link
generated in the Git Repo for *GolfGreen*.  

Step 3 - DO NOT OPEN THE project when prompted to.  Keep the project closed and select the import option. 

Step 4 - Then import the project from Maven and ensure that the Java language level is 
set at 1.8. 

Step 5 - In the dropdown next to the run and debug symbols, create an app
configuration and call it "app".  This will allow you to build the app fully.

Step 6 - Run the project and your app should be up and running.


**Basic User Instructions**

The *GolfGreen* app is a fairly straight forward app that can be used by
any android user. 

1) Upon building the app, you will look for the *GolfGreen* launcher icon.

2) You will be prompted to sign in with Google sign-in. Please sign
in with a valid google account. Currently, app users are only able 
to use the app if they have a google account. 

3) After signing you will be brought to the app's *Home*.  The app 
allows you to search in the top bar to find courses in 3 different cities.
The current supported cities, are Albuquerque, Santa Fe, and Las Cruces.  
There is also a navigation drawer that has some features that are not quite
ready for launch.  

4) If you search a location data in the form of courses will be displayed 
on the screen.  There is a guide at the top of the screen that lets
the user know what data they are exactly reading. 

5) If you would like to search the different locations you certainly can 
by simply pressing your devices back arrow to take you back to the homepage. 

**Aesthetic and Cosmetic Improvements**

* Fix the error that exists within the background image of the <code>RecyclerView</code>.

* Have clear labels of the data that the user is reading upon executing a search of a location.

* Design the cards in the <code>RecyclerView</code> further and allow each course 
to have a custom image attached with each one.

**Stretch Goals**

* Favorite course saving option that ties to the user.

* More locations to search from, and maybe a dropdown of the supported locations
to keep it clear and simple for the user.

* Allow the user to set their own profile picture and change their settings more 
freely.

* Create individual course pages that expand on the the course itself, so after you 
search a location you can also go into the individual courses page and learn more. 

* Ability to call the course directly from the app. 


**Could the app be useful on its own, with not connection to the Internet?**

The app could be useful if the user off line, they are able to download the info for the selected area into a PDF
while they have an Internet connection.  The app for the most part would be dependent on the users access to 
Internet connection. 

**What sort of data would this app use or share if it had a connection to the Internet?**

The data shared would be the location and ability to load different menu's that contain the information they are looking for. 

