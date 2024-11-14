import { useState } from 'react';
import { useDispatch } from 'react-redux';
import { addPost } from '../store/slices/postSlice';
import { useNavigate } from 'react-router-dom';

export default function PostCreate() {
  const [formData, setFormData] = useState({ title: '', content: '' });
  // dispatch를 사용해서 reducer를 실행
  const dispatch = useDispatch();
  const navigate = useNavigate()

  function handleChange(e) {
    // 우리의 state를 변경하고 싶어.
    // input의 value를 우리의 state에 넣고 싶어.
    setFormData({ ...formData, [e.target.name]: e.target.value });
  }

  function handleSubmit(e) {
    // form에는 제출하고 reloading하는 기본 동작이 있어서 없애줘야함
    e.preventDefault();

    const id = Date.now() // 임시 아이디

    // payload : 전달하고 싶은 데이터 (여기서는 formData)
    // id는 서버와 연결하면 자도으로 연동 됨
    dispatch(addPost({ ...formData, id}));

    // 새로 생성한 게시글로 이동해
    navigate(`/posts/${id}`)
  }

  // 만약 로그인을 했어 : 원래꺼 return
  // 만약 로그인 안했어 : redirect
  return (
    <div>
      <h3>새 게시글 작성</h3>
      <form onSubmit={handleSubmit}>
        <label htmlFor="title">
          제목
          <input
            type="text"
            name="title"
            id="title"
            // 인풋에 입력이 되었을 때 우리의 state를 변경하고 싶어
            onChange={handleChange}
          />
        </label>
        <label htmlFor="content">
          내용
          <textarea
            type="text"
            name="content"
            id="content"
            onChange={handleChange}
          ></textarea>
        </label>
        <button>제출</button>
      </form>
    </div>
  );
}
