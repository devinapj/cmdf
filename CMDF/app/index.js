import { geolocation } from "geolocation";
import document from "document";
// Import the messaging module
import * as messaging from "messaging";

// Listen for the onopen event
messaging.peerSocket.onopen = function() {
  // Ready to send or receive messages
}
// Listen for the onerror event
messaging.peerSocket.onerror = function(err) {
  // Handle any errors
  console.log("Connection error: " + err.code + " - " + err.message);
}
// Send a message to the peer
function sendMessage() {
  // Sample data
  var data = {
    title: 'My test data',
    isTest: true,
    records: [1, 2, 3, 4],
   // Latitude: position.coords.latitude,
    //Longitude: position.coords.longitude
  }

  if (messaging.peerSocket.readyState === messaging.peerSocket.OPEN) {
    // Send the data to peer as a message
    messaging.peerSocket.send(data);
  }
}

//geolocation.getCurrentPosition(locationSuccess, locationError);

function locationSuccess(position) {
    console.log("Latitude: " + position.coords.latitude,
                "Longitude: " + position.coords.longitude);
  var demotext = document.getElementById("demotext");
}


function locationError(error) {
  console.log("Error: " + error.code,
              "Message: " + error.message);
}

let mybutton = document.getElementById("mybutton");
mybutton.onactivate = function(evt) {
  console.log("CLICKED!");
  geolocation.getCurrentPosition(locationSuccess, locationError);
  sendMessage();

}