//1.

function game(player1, hight1, age1, player2, hight2, age2) {
  let sum1 = score(hight1, age1);
  console.log(`${player1} Score: ${sum1}`);
  let sum2 = score(hight2, age2);

  console.log(`${player2} Score: ${sum2}`);

  howWinning(player1, sum1, player2, sum2);
}

function score(hight, age) {
  age = age * 5;

  return age + hight;
}

function howWinning(player1, sum1, player2, sum2) {
  if (sum1 == sum2) {
    console.log(
      `Es gibt ein Unentschieden mit einem Score von ${sum1} punktem `
    );
  } else if (sum1 > sum2) {
    console.log(
      `${player1} gewinnt das Spiel mit ${sum1} Punkten! Glückwunsch`
    );
  } else if (sum1 < sum2) {
    console.log(
      `${player2} gewinnt das Spiel mit ${sum2} Punkten! Glückwunsch`
    );
  }
}

game("Klaus", 190, 22, "Inge", 180, 30); // Inge gewinnt

game("Klaus", 180, 30, "Inge", 190, 22); // Klaus gewinnt

game("Klaus", 180, 30, "Inge", 180, 30); // Unentschieden
