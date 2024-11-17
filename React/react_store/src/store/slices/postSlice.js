import { createSlice } from "@reduxjs/toolkit";

// 초기 데이터
// = const [value, setValue] = useState(기본값)
const initialState = [
    {
      id: 1,
      title: "첫 번째 프로젝트",
      content:
        "간단한 Todo 앱을 만들었습니다. UI 구성과 상태 관리의 중요성을 배웠습니다.",
    },
    {
      id: 2,
      title: "리액트와 함께한 성장",
      content:
        "리액트를 이용해 컴포넌트 기반 개발을 익히고 재사용성을 높이는 방법을 배웠습니다.",
    },
    {
      id: 3,
      title: "팀 프로젝트 경험",
      content:
        "팀 프로젝트에서 협업하여 일정 관리 앱을 개발했고, Git을 활용한 버전 관리와 코드 리뷰의 중요성을 배웠습니다.",
    },
  ];

const postsSlice = createSlice({
  // 변수명
  name: "posts",
  // 데이터
  initialState,
  // reducers 초기 상태를 변경할 함수를 지정해줌 = 데이터에 대한 setter
  // 입력 받은 데이터를 posts에 넣어주는 setter 만들기
  reducers: {
    // state : 게시글 데이터
    addPost: (state, action) => {
      // posts에 새로운 데이터를 push
      state.push(action.payload)
    },
    // removePost: () => {

    // }
  },
});

export const { addPost } = postsSlice.actions;
export default postsSlice.reducer;
