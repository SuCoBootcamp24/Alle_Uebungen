
const submitButton = document.querySelector('#itemSend')
const itemname = document.querySelector('#itemName')
const itemquantity = document.querySelector('#itemQuantity')
const itemshop = document.querySelector('#itemShop')
const itemcategory = document.querySelector('#itemCategory')
const addItemSection = document.getElementById('addItem');
const addButton = document.querySelector('#addItemImg');
const overlay = document.createElement('div');

getItemList()

// Overlay für das Schließen hinzufügen
overlay.className = 'overlay';
document.body.appendChild(overlay);

// Funktion zum Öffnen/Schließen des addItem-Formulars
function toggleAddItem() {
  addItemSection.classList.toggle('active');
  overlay.classList.toggle('active');
}

// Event-Listener zum Öffnen durch Klicken auf das ButtonAdd-Image
addButton.addEventListener('click', toggleAddItem);

// Event-Listener für das Schließen durch den Sende-Button
submitButton.addEventListener('click', (ev) => {
  ev.preventDefault(); // Verhindert das Standardverhalten des Buttons
  toggleAddItem(); // Schließt das Formular nach dem Senden
  // Hier kannst du noch die Logik hinzufügen, um den Artikel hinzuzufügen
});

// Event-Listener zum Schließen durch Klick auf das Overlay (außerhalb der Section)
overlay.addEventListener('click', toggleAddItem);

// Optional: Sicherstellen, dass bei erneutem Klick auf das ButtonAdd-Image die Section schließt
addButton.addEventListener('click', toggleAddItem);






submitButton.addEventListener('click', (ev) => {
    const itemJson = {
      name: itemname.value,
        quantity: itemquantity.value,
        shop: itemshop.value,
        category: itemcategory.value
    }
    fetch('http://localhost:8080/api/v1/list', {
        method: 'POST',
        headers: {
            'content-type': 'application/json'
        },
        body: JSON.stringify(itemJson)
    })
    .then (res => {
      if (res.ok) {
        getItemList()
      }
    })
})


function getItemList() {

  fetch('http://localhost:8080/api/v1/list')
  .then (res => res.json())
  .then (data => {

    const categories = document.querySelectorAll('section[id$=".itemlist"]');
    categories.forEach(category => {
      category.innerHTML = '';
    });

    data.forEach(element => {
      const category = document.getElementById(element.category + '.itemlist')
      
      if (category) {
        const article = document.createElement('article');
        article.className = 'articleBox';
        
        const articleText = document.createElement('div');
        if (element.bought) {
          articleText.className = 'articleText isBought';
        } else {
        articleText.className = 'articleText';
        }
        articleText.addEventListener('click', (ev) => {
          ev.preventDefault();
          updateItem(element.id, element.bought)
        })

        const paragraph1 = document.createElement('p');
        paragraph1.textContent = element.name;
  
        const paragraph2 = document.createElement('p');
        paragraph2.className = 'pcs';
        paragraph2.textContent = element.quantity + " pcs";

        const paragraph3 = document.createElement('p');
        paragraph3.className = 'shops';
        paragraph3.textContent = element.shop;

        articleText.appendChild(paragraph1);
        articleText.appendChild(paragraph2);
        articleText.appendChild(paragraph3);

        const articleImg = document.createElement('div');
        articleImg.className = 'articleImg';
        articleImg.addEventListener('click', (ev) => {
          ev.preventDefault();
          deleteItem(element.id)
        })

        const img = document.createElement('img');
        img.src = './assets/img/delete.svg';
        img.className = 'deleteImg';
        img.alt = 'delete button';

        articleImg.appendChild(img);

        article.appendChild(articleText);
        article.appendChild(articleImg);

        category.appendChild(article);
      }
    });
  })
}

function updateItem(id, bought) {
  let isBought

  if (bought) {
    isBought = false
  } else {
    isBought = true
  }

  const itemJson = {
    bought: isBought
  }

  fetch('http://localhost:8080/api/v1/list/' + id, {
    method: 'PUT',
    headers: {
      'content-type': 'application/json'
    },
    body: JSON.stringify(itemJson)
  })
  .then (res => {
    if (res.ok) {
      getItemList()
    }
  })
}




function deleteItem(id) {

  fetch('http://localhost:8080/api/v1/list/' + id, {
    method: 'DELETE'
  })
  .then (res => {
    if (res.ok) {
      getItemList()
    }
  })
}



function groupingToggle(category) {
  const section = document.getElementById(category + '.itemlist')
  const groupingImg = document.getElementById(category + '.groupingImg')
  if (section.className == 'hidden') {
    section.className = '';
    groupingImg.src = './assets/img/GroupClose.svg'
    groupingImg.alt = 'Group closing'
  } else {
    section.className = 'hidden';
    groupingImg.src = './assets/img/GroupOpen.svg'
    groupingImg.alt = 'Group opening'
  }
}