let toDoList = []

const addToList = function (event) {
  event.preventDefault();
  
  const list = document.getElementById("list-entry");
  const inputValue = list.value.trim();

  if (inputValue === "") {
    alert("Please enter at least one item.");
    return;
  }

  const newItems = inputValue.split(/\r?\n/)
    .map(item => item.trim())
    .filter(item => item !== "");

  toDoList = toDoList.concat(newItems);

  renderList(toDoList);

  list.value = ""; 
}

const getItem = function () {
  if (toDoList.length === 0) {
    alert("The todo list is empty. Please add items first.");
    return;
  }

  const item = toDoList[Math.floor(Math.random() * toDoList.length)];
  const itemNode = document.createTextNode(item);
  document.querySelector(".randomized-item p").replaceChildren(itemNode);
}

const renderList = function (list) {
  const d = document.getElementsByClassName("display-list")[0];
  d.innerHTML = "<h2>To Do</h2>"; 

  list.forEach((item, index) => {
    const row = document.createElement("div");
    const text = document.createTextNode(item);
    const removeButton = document.createElement("button");
    removeButton.textContent = "Remove";
    removeButton.onclick = () => removeItem(index);

    row.appendChild(text);
    row.appendChild(removeButton);
    d.append(row);
  });
}

const removeItem = function (index) {
  toDoList.splice(index, 1); 
  renderList(toDoList); 
}