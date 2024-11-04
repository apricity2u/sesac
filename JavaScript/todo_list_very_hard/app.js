// // API 베이스 URL
const URL = 'http://localhost:3000/todos';

// // DOMContentLoaded : HTML 문서 로딩이 끝나면 실행되는 이벤트
// // 페이지가 로드되면 Todo 목록 초기화 함수를 실행한다.

document.addEventListener('DOMContentLoaded', initTodos);

// todo list를 생성하는 함수
// 텍스트 + 완료버튼 + 삭제버튼
function renderToDo(todo) {
  // <ul> 내부 <li> 만들기
  const container = document.querySelector('.container');
  const toDoBlock = document.createElement('div');
  toDoBlock.classList.add('flexbox', 'margin');

  // <li> 내부 <span> 만들기
  const toDoContent = document.createElement('span');
  toDoContent.textContent = todo.content;

  // <li> 내부 '완료' <button> 만들기
  const finishButton = document.createElement('button');
  finishButton.textContent = '완료';
  finishButton.classList.add('finish-button');
  finishButton.addEventListener('click', async (event) => {
    // 클로저로 인해 초기 값이 저장되므로, completed 상태를 반대로 바꿔줌
    // 상세한 내용은 최하단 주석에서 확인
    todo.completed = !todo.completed;

    toDoContent.classList.toggle('completed');
    finishButton.classList.toggle('completed');
    deleteButton.classList.toggle('completed');

    await completedTodo(todo.id, todo.completed);
  });

  // <li> 내부 '삭제' <button> 만들기
  const deleteButton = document.createElement('button');
  deleteButton.textContent = '삭제';
  deleteButton.classList.add('delete-button');
  deleteButton.addEventListener('click', async (event) => {
    toDoBlock.remove();
    await deleteTodo(todo.id);
  });

  // 새로고침 했을 때, 완료 상태가 유지되려면 필요함
  if (todo.completed) {
    toDoContent.classList.add('completed');
    finishButton.classList.add('completed');
    deleteButton.classList.add('completed');
  }
  // <li> 내부에 텍스트, 완료버튼, 삭제버튼 넣기
  toDoBlock.append(toDoContent, finishButton, deleteButton);
  container.append(toDoBlock);
}

// <GET>
// 1. 새로고침할 때마다 현재 database에 있는 todo List를 조회하는 기능 만들기

// 1-1. fetch로 database에 있는 데이터를 가져온다. (GET)
// 1-1-a. data는 array 내부에 object가 있는 형태
// 1-1-b. forEach 함수를 통해서 각 object마다 renderToDo 함수를 실행한다.

async function initTodos() {
  const response = await fetch(URL);
  const data = await response.json();

  data.forEach((datum) => {
    renderToDo(datum);
  });
}

// <POST>
// 2. 추가 버튼을 누르면 todo가 database에 추가되고, 화면 상에도 todo list에도 표시된다.

// 2-1. 추가 버튼을 눌렀을 때
// 2-1-a. input value가 서버에 추가된다 (POST)
// 2-1-b. completed의 초기 상태는 '완료 전'이므로 'false'로 고정

// 2-2. todo list에 입력한 todo를 추가한다.
// 2-2-a. 추가한 데이터를 renderToDo 함수에 넣어 화면 상으로 todo를 확인할 수 있게 해준다.
const addTodoButton = document.querySelector('#add-todo');
addTodoButton.addEventListener('click', addTodo);

async function addTodo() {
  const inputTag = document.querySelector('#todo-input');

  const response = await fetch(URL, {
    method: 'POST',
    body: JSON.stringify({
      content: inputTag.value,
      completed: false,
    }),
    headers: {
      'Content-type': 'application/json; charset=UTF-8',
    },
  });
  const data = await response.json();
  renderToDo(data);
}

// <PATCH>
// 3. 완료버튼을 누르면 가운데 줄이 toggle된다

// 3-1. 서버
// 3-1-a. database 상에 completed 상태를 변경한다 (PATCH => id 필요)
// 3-1-b. completed가 false -> true // true -> false

// 3-2. 클라이언트
// 3-2-a. 텍스트 및 버튼에 줄 긋기

async function completedTodo(id, completed) {
  const response = await fetch(`${URL}/${id}`, {
    method: 'PATCH',
    body: JSON.stringify({
      completed: completed,
    }),
    headers: {
      'Content-type': 'application/json; charset=UTF-8',
    },
  });
  const data = await response.json();
  return data;
}

// <DELETE>
// 4. 삭제 버튼을 누르면 todo가 서버에서 사라지고, todo list에도 사라진다.

// 4-1. 삭제 버튼을 누르면
// 4-1-a. 서버에서 데이터가 삭제된다. (DELETE => id 필요)
// 4-1-b. todo list에서도 사라진다.

async function deleteTodo(id) {
  const response = await fetch(`${URL}/${id}`, {
    method: 'DELETE',
    headers: {
      'Content-type': 'application/json; charset=UTF-8',
    },
  });
  const data = await response.json();
  return data;
}

///////////////////////////////////////////////////////////////////////////

// <클로저 기능 확인>

// finishButton.addEventListener('click',

//  (e) => {
//   toDoBlock.classList.toggle('completed');
//   finishButton.classList.toggle('completed');
//   deleteButton.classList.toggle('completed');
//   console.log({id: 1, content: '예습하기', completed: true});
//   completedTodo(1, true);
// }
//);

// function foo() {
//   toDoBlock.classList.toggle('completed');
//   finishButton.classList.toggle('completed');
//   deleteButton.classList.toggle('completed');
//   console.log({id: 4, content: '예습하기', completed: true});

//   completedTodo(4, true);
// }

///////////////////////////////////////////////////////////////////////////
