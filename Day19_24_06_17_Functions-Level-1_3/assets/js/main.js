//1.

function intro() {
  let name = window.prompt("ein Name eingeben");
  let city = window.prompt("ein Stadt eingeben");
  let age = window.prompt("ein age eingeben");
  intro2(name, city, age);
}

function intro2(name, city, age) {
  console.log(
    `Hallo, mein Name ist ${name}. Ich bin ${age} Jahre alt. Ich komme aus ${city}.`
  );
}
