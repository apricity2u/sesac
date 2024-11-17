import { configureStore } from "@reduxjs/toolkit";
import postsReducer from "./slices/postSlice";
import isLoginReducer from "./slices/loginSlice"

// 조각들을 모아놓는 곳

const store = configureStore({
  reducer: {
    posts: postsReducer,
    isLogin: isLoginReducer
  },
});

export default store;
