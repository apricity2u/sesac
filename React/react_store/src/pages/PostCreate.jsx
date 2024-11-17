import { useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { addPost } from '../store/slices/postSlice';
import { useNavigate } from 'react-router-dom';

export default function PostCreate() {

  // formData는 PostCreate에서 사용할 데이터로 state로 관리
  const [formData, setFormData] = useState({ title: '', content: '' });
  // dispatch를 사용해서 reducer를 실행
  const dispatch = useDispatch();
  const navigate = useNavigate();

  // 함수를 따로 utils 폴더에 넣어 관리할 수 있음
  function handleChange(e) {
    // 우리의 state를 변경하고 싶어.
    // input의 value를 우리의 state에 넣고 싶어.
    setFormData({ ...formData, [e.target.name]: e.target.value });
  }

  function handleSubmit(e) {
    // form에는 제출하고 reloading하는 기본 동작이 있어서 없애줘야함
    e.preventDefault();

    const id = Date.now(); // 임시 아이디

    // payload : 전달하고 싶은 데이터 (여기서는 formData)
    // id는 서버와 연결하면 자동으로 연동 됨
    dispatch(addPost({ ...formData, id }));

    // 새로 생성한 게시글로 이동해
    navigate(`/posts/${id}`);
  }

  // 만약 로그인을 했어 : 원래꺼 return
  // 만약 로그인 안했어 : redirect
  const { isLogin } = useSelector((state) => state.isLogin);

  // if (!isLogin) {
  //   return <div>어딜 들어와</div>
  // }

  // 최초 한 번 & Login 했을 때도 실행하면 좋겠음
  // 홈화면으로 보내는 것보다 로그인을 할 수 있도록 유도하면 어떨까?
  useEffect(() => {
    if (!isLogin) {
      navigate('/');
    }
  }, [isLogin]);

  return (
    <div>
      <h3>새 게시글 작성</h3>
      <form onSubmit={handleSubmit}>
        {/* label 안에 자식으로 input 태그를 넣는 방법도 있다. (block 단위는 불가능) */}
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
