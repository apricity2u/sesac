// 1

let todos = []

todos.push({
  "todoId": 1,
  "content": "예습하기",
  "isCompleted": false
},
{
  "todoId": 2,
  "content": "강의듣기",
  "isCompleted": false
},
{
  "todoId": 3,
  "content": "복습하기",
  "isCompleted": false
})

console.log(todos)

console.log('----------------------')

// 2

for (let todo of todos) {
  const content = todo.content;
  const isCompleted = todo.isCompleted;

  console.log(`content: ${content}, isCompleted: ${isCompleted}`)
}

console.log('----------------------')

// 3

for (let todo of todos) {
  if (todo.todoId === 2) {
    console.log(todo);
  }
}

console.log('----------------------')

// 4

for (let todo of todos) {
  if(todo.todoId === 2) {
    todo.isCompleted = true
  }
}

console.log(todos)
