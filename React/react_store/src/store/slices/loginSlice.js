import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  isLogin : false
  // isAdmin : false,
  // user : {
  //  name : 'anonimoususer'
  // }
};

const isLoginSlice = createSlice({
  name: "isLogin",
  initialState,
  reducers: {
    changeLoignStatus: (state, action) => {
      state.isLogin = !state.isLogin
    }
  }

  // 로그인과 로그아웃이 과연 같은 기능일까?
  // login: (state, action) => {
  //  state.isLogin = True;  
  // },
  // logout: (state, action) => {
  //  state.isLogin = false;  
  // },

});

export const { changeLoignStatus } = isLoginSlice.actions;
// export const { login, logout } = isLoginSlice.actions;
export default isLoginSlice.reducer;
