import axios from 'axios';

// 현재는 posts에 대한 instance
const instance = axios.create({
  baseURL: 'http://localhost:3000/posts',
  // baseURL: import.meta.env.VITE_API_URL + '/posts',
});

// axios.get("http://localhost:3000/posts")
// axios.post(`http://localhost:3000/posts/${postId}`)
// 위의 코드를 아래처럼 사용할 수 있다.
// instance.get('')
// instance.post(`/${postId}`)

export default instance;
