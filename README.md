# Wildlife Tracker App Using Java Spark Program

### This project is about Wildlife Tracker App Using Java Program, Version:11.0.17 LTS Date: 8th June 2023.

### Author:**David Muthui Ndungu**

## Description
- This project is my week three Java IP about Wildlife Tracker App.

## What is Wildlife Tracker App?
- The Forest Service is considering a proposal from a timber company to clearcut a nearby forest of Douglas Fir. 
- Before this proposal may be approved, they must complete an environmental impact study.In this regards,the app has been developed.
- The Wildlife Tracker App is a web application built to help Rangers track wildlife sightings in a specific area. 
- The application allows Rangers to record sightings of animals and endangered animals, along with relevant information such as location and Ranger details. 
- It also provides features like reporting exceptions and storing timestamps for each sighting.


## BDD
- Categories of Wildlife
- The application tracks two categories of wildlife:

- Regular Animals:
     * Regular Animal ID.
     * Name.
     * Health:Okay or healthy.
     * Age:Adult or Middle age
       
- Endangered Animals:
     * Endangered Animal ID.
     * Animal Name
     * Health (Options: "healthy", "ill", "okay")
     * Age (Options: "newborn", "young", "adult")

- Sightings
     * When a wildlife species is spotted, a Ranger can submit a Sighting form containing the following details:
     * ID of Regular Animal or Endangered Animal species
     * Location (Conveyed in any manner chosen, e.g., "Zone A", "Near the River", "NE Quadrant", or latitude and longitude values)
     * Ranger Name ,badge number, contact information.

## Steps for the problem
- Enter the details that include and not limited to:
- Enter Regular animals name
- Enter Endangered Animals:
  * Name
  * Health (Options: "healthy", "ill", "okay")
  * Age (Options: "newborn", "young", "adult")
- Add a new ranger in the Database.
- Add a new location in the Database.

- Report/Record Sightings
  When a wildlife species is spotted, a Ranger can submit a Sighting form containing the following details:
* Regular animal or Endangered Animal species
* Location (Conveyed in any manner chosen, e.g., "Zone A", "Near the River", "NE Quadrant", or latitude and longitude values)
* Ranger Name:Ranger's details should include contact information, a badge number, etc


## **Expected output is either**
- After running the main App.java on IntelliJ IDEA,the user goes to the browser localhost 4567.
- The User end interface is loaded where:
- Get your output which includes:
* View a list of Relugar animal and be able to delete.
* View a  of Endagered animal and be able to delete.
* View a list of the Sighting Report/recording which includes:
  - Animal category(Regular/Endangered animal).
  - Animal name.
  - Location animal was sighted.
  - The ranger with name,badge number & contact who recorded the sighting.
  - Time stamp the sighting was recorded.
* View a list of Locations with Zone name, Zone Description,Zone Quadrant,Number of sightings.
* View a list of all the rangers with the Rangers name,Rangers badge number,Rangers description,Number of rangers sighting for the day.

## Setup/Installation Requirements
- Create a Database using CREATE DATABASE wildlife_tracker;
  \l -lists the database that have been created
  \c -connects to the created database.
- Run the code using the Intellij IDEA and go to the browser and run the Front/User end output on localhost:4567. 
- Ensure that dependencies are installed on build.gradle.These icludes:
- Dependencies:
     * testImplementation platform('org.junit:junit-bom:5.9.1')
     * testImplementation 'org.junit.jupiter:junit-jupiter'
     * implementation 'com.sparkjava:spark-core:2.9.4'
     * implementation 'org.slf4j:slf4j-simple:2.0.7'
     * implementation 'com.sparkjava:spark-template-handlebars:2.7.1'
     * implementation 'org.apache.commons:commons-lang3:3.12.0'
     * implementation 'com.github.jknack:handlebars:4.1.2'
     * implementation 'org.postgresql:postgresql:42.6.0'
     * implementation 'org.apache.spark:spark-core_2.13:3.4.0'
     * implementation 'org.postgresql:postgresql:42.6.0'
     * implementation 'org.sql2o:sql2o:1.6.0'
     * implementation 'com.google.code.gson:gson:2.8.9'
                

- If the project has no errors, it will execute as expected.

## Psql commands used include:
- CREATE DATABASE wildlife_tracker;
   * \l -lists the database that have been created
   * \c -connects to the created database

## For Regular Animal table
- CREATE TABLE regular_animal(regular_animal_id SERIAL PRIMARY KEY, animalName varchar, health varchar, age varchar, deleted boolean default false);
- CREATE TABLE IF NOT EXISTS regular_animal(regular_animal_id SERIAL PRIMARY KEY, animalName varchar, health varchar, age varchar, deleted boolean default false);
- CREATE TABLE regular_animal(regular_animal_id SERIAL PRIMARY KEY, animalName varchar, health varchar, age varchar, deleted boolean default false);
- INSERT INTO regular_animal(animalName, health, age, deleted) VALUES (UPPER(:animalName), :health, :age, false);
- UPDATE regular_animal SET deleted = (true) WHERE animalName = (:animalName);
- SELECT * FROM regular_animal WHERE not deleted;
- DROP TABLE regular_animal;
- UPDATE regular_animal SET deleted = (true) WHERE animalName = (:animalName);

## For Endangered animal table
- CREATE TABLE endangered_animal(endangered_animal_id SERIAL PRIMARY KEY, endangeredAnimalName varchar, health varchar, age varchar, deleted boolean default false);
- CREATE TABLE IF NOT EXISTS endangered_animal (endangered_animal_id SERIAL PRIMARY KEY, endangeredAnimalName varchar, health varchar, age varchar, deleted boolean default false);
- INSERT INTO endangered_animal(endangeredAnimalName, health, age, deleted) VALUES (UPPER(:endangeredAnimalName), :health, :age, false);
- SELECT * FROM endangered_animal WHERE not deleted;
- DROP TABLE endangered_animal;
- UPDATE endangered_animal SET deleted = (true) WHERE endangeredAnimalName = (:endangeredAnimalName);
- DELETE FROM endangered_animal WHERE not deleted AND endangeredAnimalName = '';

## For the report/record sightings table
- CREATE TABLE sightings (sighting_id SERIAL PRIMARY KEY,animal_category varchar, animal_name varchar, location varchar, rangers_name varchar, deleted BOOLEAN DEFAULT false);
- CREATE TABLE IF NOT EXISTS sightings (sighting_id SERIAL PRIMARY KEY,animal_category varchar, animal_name varchar, location varchar, rangers_name varchar, deleted BOOLEAN DEFAULT false);
- INSERT INTO sightings (animal_category, animal_name, location, rangers_name, deleted) VALUES (UPPER(:animal_category), :animal_name, :location, UPPER(:rangers_name), false);
- UPDATE sightings SET deleted = (true) WHERE animal_name = (:animal_name);
- SELECT * FROM sightings WHERE not deleted;
- DROP TABLE sightings;

## For Rangers table
- CREATE TABLE rangers(rangers_id SERIAL PRIMARY KEY, rangers_name varchar, badge_number varchar UNIQUE, rangers_contact integer UNIQUE, rangers_description varchar, rangers_sightings varchar,deleted BOOLEAN DEFAULT false);
- CREATE TABLE IF NOT EXISTS rangers(rangers_id SERIAL PRIMARY KEY, rangers_name varchar, badge_number varchar UNIQUE, rangers_contact integer UNIQUE, rangers_description varchar, rangers_sightings varchar,deleted BOOLEAN DEFAULT false);
- INSERT INTO rangers(rangers_name, badge_number, rangers_contact, rangers_description, rangers_sightings,deleted) VALUES (UPPER(:rangers_name), :badge_number, :rangers_contact,UPPER(:rangers_description),UPPER(:rangers_sightings), false);
- SELECT * FROM rangers WHERE not deleted;
- UPDATE rangers SET deleted = (true) WHERE rangers_name = (:rangers_name);

## For Locations table
- CREATE TABLE locations(locations_id SERIAL PRIMARY KEY, zones_name varchar, zones_descriptions varchar, zones_quadrant varchar, location_sightings varchar,deleted BOOLEAN DEFAULT false);
- CREATE TABLE IF NOT EXISTS locations(locations_id SERIAL PRIMARY KEY, zones_name varchar, zones_descriptions varchar, zones_quadrant varchar, location_sightings varchar,deleted BOOLEAN DEFAULT false);
- INSERT INTO locations(zones_name, zones_descriptions, zones_quadrant, location_sightings, deleted) VALUES (UPPER(:zones_name), UPPER(:zones_descriptions), UPPER(:zones_quadrant), UPPER(:location_sightings), false);
- SELECT * FROM locations WHERE not deleted;
- UPDATE locations SET deleted = (true) WHERE zones_name = (:zones_name);

## Further Explorations
Consideratin of adding any combination of the following additional features:
- Build a Ranger class. This could include contact information, a badge number, etc. then, associate each Sighting with a Ranger object instead of just a name. Include a page where users may see all Rangers, and click each to see which Sightings they have reported.
- Build a Location class. Associate each Sighting with a Location object instead of just including a location property. Include a page where users may see all Locations in the area, and click one to see all Sightings reported in that region.
- Integrate a drop-down menu that allows the Ranger to select which animal species they have seen.
- Format timestamps for each sighting, and display in your front-end user interface.
- Allow users to sort Sightings by most recent.
- Implement a many-to-many relationship. Assume a sighting may now include multiple species, and animals may be included in multiple sightings.
  Important: If you update your database structure in any fashion, do not forget to update your README's database setup instructions, including the exact setup steps required to re-create your database.
- Brainstorm other errors or misuses of the application that could occur, and include additional exceptions to combat them.

## To access for code for learning:

- Go to Git clone https://github.com/dmuthui/-MoringaSchoolJava-Week3IP-WildLifeTrackerApplication.git

- Open cloned code on IntelliJ
- Run on the Code to view inputs/outputs for the Wildlife Tracker App.

## Known Bugs
There are no known bugs on this project.

## Technologies Used
-   Written in Java (JDK 11.0.17).
-   Used Gradle 8.0.2 as a build tool, JVM:11.0.17 and Groovy:3.0.13
-   Used SQL Shell (psql) - Postgres for the creation of Database.
-   Used the IntelliJ IDEA as code editor for compiling and running the source code.
-   Other Dependencies include:
      * junit.jupiter.
      * Spark Core.
      * Template Handlebars.
      * simple:2.0.7.

## Support and contact details
- If you need any assistance on any issues or have questions, ideas or concerns. Kindly contact me through email: vyda2002us@gmail.com to make a contribution to the code or for any assistance on the Heroes Squad App project.

## GitHub URL Link
- To be able to view the project click on https://github.com/dmuthui/-MoringaSchoolJava-Week3IP-WildLifeTrackerApplication.git


### License
_The License used is GPL_

### Copyright (c) 2023 **Wildlife Tracker App @ David Muthui Ndungu**