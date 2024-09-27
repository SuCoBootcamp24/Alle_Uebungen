//1.

function ageConfirm(event) {
  event.preventDefault();
  const ageInput = document.querySelector("#age").value;
  const outputText = document.querySelector(".output");
  if (ageInput >= 18) {
    outputText.style.color = "green";
    outputText.innerText = "Ja, Du kannst Shisha rauchen";
  } else {
    outputText.style.color = "red";
    outputText.innerText = "Du darfst noch nicht Shisha rauchen";
  }
}
