import { geolocation } from "geolocation";
import document from "document";
// Import the messaging module
import * as messaging from "messaging";
import * as fs from "fs";

function locationSuccess(position) {
    console.log("Latitude: " + position.coords.latitude,
                "Longitude: " + position.coords.longitude);
}

function locationError(error) {
  console.log("Error: " + error.code,
              "Message: " + error.message);
}

let mybutton = document.getElementById("mybutton");
mybutton.onactivate = function(evt) {
  console.log("Location Sent!");
  geolocation.getCurrentPosition(locationSuccess, locationError);
}
