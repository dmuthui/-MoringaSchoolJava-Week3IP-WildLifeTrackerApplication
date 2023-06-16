$(document).ready(function() {
  // Initialize WOW.js for animations
  new WOW().init();

  // Typed.js for typing effect
  var typed = new Typed("#type", {
    strings: [
      "<span style='color:black;'>Wildlife Tracker</span>",
      "<span style='color:black;'>An application that allows Rangers to track wildlife sightings in the area on every occurrence and record.</span>"
    ],
    backSpeed: 70,
    typeSpeed: 80,
    smartBackspace: true,
    loop: true
  });
  });

//FUNCTION THAT GIVES AN ALERT IF YOU WANT TO DELETE A REGULAR ANIMAL
//AN ALERT THAT POPS WHEN YOU WANT TO DELETE A HERO FROM THE HEROES LIST
 function confirmDeletion(animalName) {
     var result = confirm("Are you sure you want to delete the regular animal " + animalName + "?");
     if (!result) {
         return false; // Cancel button was clicked, return false to prevent deletion
     }
     // Perform the deletion action
     window.location.href = "/delete-regularAnimal/" + animalName;
 }

 //VALIDATES ADDANIMALFORM DATA ENTRY:SENDS ALERT WHEN YOU CLICK BLANK FORM FOR SUBMISSION
 function validateForm() {
     var animalName = document.getElementById("animalName").value.toUpperCase().trim(); // Trim whitespace

     if (animalName === "") {
         alert("Please fill in all the fields before submitting the form.");
         return false; // Prevent form submission
     }

 }
