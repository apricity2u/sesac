import { createSlice } from "@reduxjs/toolkit";

const initialState = {isLogin : false};

const isLoginSlice = createSlice({
  name: "isLogin",
  initialState,
  reducers: {
    changeLoignStatus: (state, action) => {
      state.isLogin = !state.isLogin
    }
  }
});

export const { changeLoignStatus } = isLoginSlice.actions;
export default isLoginSlice.reducer;
