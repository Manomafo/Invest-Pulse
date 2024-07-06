const eyeElement = document.getElementById("visibility");
const eyeOffElement = document.getElementById("visibility-off");
let ispasswordViewEnable = false;

function togleVisibility() {
  if (ispasswordViewEnable) {
    eyeElement.style.display = "none";
    eyeOffElement.style.display = "inline";
    document.getElementById("password").setAttribute("type", "text");
    ispasswordViewEnable = false;
  } else {
    eyeElement.style.display = "inline";
    eyeOffElement.style.display = "none";
    document.getElementById("password").setAttribute("type", "password");
    ispasswordViewEnable = true;
  }
}
