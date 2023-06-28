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

//FUNCTION THAT GIVES AN ALERT IF YOU WANT TO DELETE A REGULAR ANIMAL/ENDANGERED ANIMAL
 function confirmDeletion(animalName) {
     var result = confirm("Are you sure you want to delete the  animal " + animalName + "?");
     if (!result) {
         return false; // Cancel button was clicked, return false to prevent deletion
     }
     // Perform the deletion action
     window.location.href = "/delete-regularAnimal/" + animalName;
 }
//FUNCTION THAT GIVES AN ALERT IF YOU WANT TO DELETE A SIGHTING
 function confirmDelete(animal_name) {
     var result = confirm("Are you sure you want to delete the  animal " + animal_name + "?");
     if (!result) {
         return false; // Cancel button was clicked, return false to prevent deletion
     }
     // Perform the deletion action
     window.location.href = "/delete-animal_name/" + animal_name;
 }

 //FUNCTION THAT GIVES AN ALERT IF YOU WANT TO DELETE A RANGER
  function confirmsDelete(rangers_name) {
      var result = confirm("Are you sure you want to delete the  ranger " + rangers_name + "?");
      if (!result) {
          return false; // Cancel button was clicked, return false to prevent deletion
      }
      // Perform the deletion action
      window.location.href = "/delete-rangers_name/" + rangers_name;
  }

   //FUNCTION THAT GIVES AN ALERT IF YOU WANT TO DELETE A LOCATION
    function confirmedDelete(zones_name) {
        var result = confirm("Are you sure you want to delete the location " + zones_name + "?");
        if (!result) {
            return false; // Cancel button was clicked, return false to prevent deletion
        }
        // Perform the deletion action
        window.location.href = "/delete-zones_name/" + zones_name;
    }
 //VALIDATES ADD ANIMAL FORM DATA ENTRY:SENDS ALERT WHEN YOU CLICK BLANK FORM FOR SUBMISSION
 function validateForm() {
     var animalName = document.getElementById("animalName").value.toUpperCase().trim(); // Trim whitespace
     if (animalName === "") {
         alert("Please fill in all the fields before submitting the form.");
         return false; // Prevent form submission
     }

 }
//SCRIPT FUNCTIONS TO LINK ANIMALS ON THE RADIO BUTTONS TO THE REGULAR/ENDANGERED ANIMAL LIST

//Endangered Animal radio button function to populate animal name from the endangered animal List
document.addEventListener('DOMContentLoaded', function() {
    var regularAnimalRadio = document.getElementById('regularAnimal');
    var endangeredAnimalRadio = document.getElementById('endangeredAnimal');
    var animalNameDropdown = document.getElementById('animal_name');

    regularAnimalRadio.addEventListener('change', function() {
      if (regularAnimalRadio.checked) {
          // Uncheck the endangered animal radio button
          endangeredAnimalRadio.checked = false;
        }
        // Make an AJAX request to fetch the list of regular animals
        fetch('/regular-animals')
            .then(response => response.json())
            .then(data => {
                // Update the animal name dropdown with the fetched data
                animalNameDropdown.innerHTML = '';
                data.forEach(animal => {
                    var option = document.createElement('option');
                    option.textContent = animal.animalName;
                    animalNameDropdown.appendChild(option);
                });
            })
            .catch(error => console.log(error));
    });
//Endangered Animal radio button function to populate animal name from the endangered animal List
    endangeredAnimalRadio.addEventListener('change', function() {
        if (endangeredAnimalRadio.checked) {
        // Uncheck the regular animal radio button
        regularAnimalRadio.checked = false;
        }

        // Make an AJAX request to fetch the list of endangered animals
        fetch('/endangered-animals')
            .then(response => response.json())
            .then(data => {
                // Update the animal name dropdown with the fetched data
                animalNameDropdown.innerHTML = '';
                data.forEach(animal => {
                    var option = document.createElement('option');
                    option.textContent = animal.endangeredAnimalName;
                    animalNameDropdown.appendChild(option);
                });
            })
            .catch(error => console.log(error));
    });
});

//For searching anything on the pages with a table
$(document).ready( function () {
    $('#animalsList').DataTable();
    $('#locationList').DataTable();
    $('#rangersList').DataTable();
    $('#sightingList').DataTable();
} );