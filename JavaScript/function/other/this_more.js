// this 심화

// person 이라는 객체가 있습니다.
const person = {
  name: "John",
  friends: ["Jane", "Mike"],

  //
  printFriends_wrong() {
    this.friends.forEach(
      // 여기서 this는 person
      // this.friends는 ['Jane', 'Mike']
      // this.friends.forEach는 ['Jane', 'Mike'] 안에 원소들을 불러옵니다.

      // 콜백함수에서 일반 함수사용
      function (friend) {
        console.log(this.name + " knows " + friend);
        // 여기서 this는 전역객체 안에서 찾게 됩니다.
        // 왜 전역객체에서 찾을까요?
        // forEach 내부의 일반 함수는 새로운 컨텍스트를 가지게 됩니다.
        // forEach의 콜백 함수는 전역 컨텍스트에서 실행되므로 전역 객체를 가리킵니다.

        // this.name은 전역객체 안에 없기 때문에 undefined 가 뜹니다.
        // friend는 friends 라는 array 안에 있는 원소들을 인자 값으로 받는 매개변수입니다.
        // 따라서 friends 안에 있는 요소들이 출력됩니다.
        // undefined knows jane & undefined knows mike
      }
    );
  },

  printFriends_right() {
    this.friends.forEach((friend) => {
      // 여기서 this는 person
      // this.friends는 ['Jane', 'Mike']
      // this.friends.forEach는 ['Jane', 'Mike'] 안에 원소들을 불러옵니다.

      // 콜백함수에서 화살표함수를 사용
      console.log(this.name + " knows " + friend);
      // 화살표함수는 this에 대한 바인딩 값을 무시하게 됩니다.
      // 결국 상위에서 this를 찾게 됩니다.
      // printFriends_right가 아닌 person에서 this를 찾게 됩니다.
      // person.name = john이기 때문에 오류가 나지 않습니다.
      // john knows jane & john knows mike
    });
  },
};

person.printFriends_wrong(); // printFriends_wrong() 의 this는? -> person
person.printFriends_right(); // printFriends_right() 의 this는? -> person
