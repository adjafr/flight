# flight
FastTrack'D Final Project Starter



---Purpose----

The purpose of this project was to teach each of us how to individually create a website for a regional airline that enables guests to 
view all available flights which update in realtime.  This site also allows guests to register as users and then login to their 
individual profile pages 

From their individual profile pages users can search for available flight paths based on their origin and destination between the 4 
Tennessee cities our regional airline covers.  These flight paths include the flight(s) from the origin to the destination, as well as 
each flight's duration, departure time, arrival time, the total layover time of each flight path and the total trip time of each flight 
path.  Each flight path is listed in ascending order from the shortest total trip time to the longest total trip time regardless of how 
many connecting flights each flight path has and like the available flights this list is also updated in realtime.  If there is no 
available route based on the user's origin and destination that day the user will be made aware of the issue.  Otherwise, from that page 
the user may click on their preferred flight path which books that flight for them and adds it to their list of saved itineraries.  

The user may also view all of their saved itineraries in ascending order based on the date they were originally booked.  The user then 
has the option to click on a specified itinerary to be routed to a seperate page that shows that specific itinerary and it's flight-path 
via Google Maps.  All the individual flights on the flight-path have seperate color lines and the origin has no marker so as to make it 
obvious where the flight-path begins.  All the saved flights are saved in our database, for the purpose of this project we used 
PostgreSQL.  


----Project Structure, technologies, and how it's all connected------
You have a client side (front-end) and then you get a request from the client side.  

On the Back-End you have these Rest Controllers on the java side (back-end) that's where the request is fed in from the client side.  
They are all Rest Controllers so you can make Rest Requests to it.  You also have flights & location controllers.  You have a User 
Controller for the User Services.  Once you have the request fed into the controller the controller passes the request to the service.  
The service has it's own methods and interfaces so that the controller can call it.  And then you have service implementations where 
your actual business logic is being processed.  From there you have all of these repositories (like the flight repository & the 
itinerary repository) which makes your call to the back-end regardless of the type of database that's being used because it can still 
make a request to the database and then get the data back for you.  This comes from the Spring JPA Repository where you provide the 
entity to it and the id you are connecting to and then it does all the back-end magic for you.

Then on the Front-End side you have the UI and all your Node Modules folder.  I installed all the required features using an npm 
install from commander which show up on the package.json and are installed in the Node Modules folder.  The package.json is telling you 
what elements you are using in your project.  These are the dependencies of the project which are required in order for the project to 
work.  I also created a webpack whichis a packaging part of the web which does the package management on the client side myself so I 
was able to customize my project my way.  This is where you say this is the entry point, this is the point where I'm at now you need to 
copy this file to this location so my web guy can run it.  I also have a POM.xml file which manages my Spring dependencies for me.  All 
my static changes are in the index html and the routing happens as I click on different menus on the top of my website which are linked 
from my index.html.  I'm using AngularJS on the front-end.


------Project Challenges-------
The back-end was quite simple for the most part though the recursive function to pull all acceptable flight paths based on the origin, 
destination, layover time, departure time & arrival times was the most complicated back-end coding I've ever done.  

Posting the flight was another challenge as well as mapping the itinerary the user selected.  
