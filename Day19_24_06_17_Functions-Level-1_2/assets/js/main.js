//1.

function intro() {
  let name = window.prompt("ein Name eingeben");
  intro2(name);
}

function intro2(paramName) {
  let name = "SuperCoder:in";

  console.log(`Hi ${name}. Mein Name ist ${paramName}`);
}
