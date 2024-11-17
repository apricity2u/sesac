import React, { useEffect, useState } from 'react';
import { useSelector } from 'react-redux';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function PostList() {
  const navigate = useNavigate();
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  // true & false 에러가 있다 없다
  // null & something 무언가가 있다 없다
  // -> something에는 여러가지가 들어갈 수 있음!
  const [error, setError] = useState(null);
  const [myInput, setInput] = useState('');

  useEffect(() => {
    // const posts = useSelector((state) => state.posts);
    async function fetchPosts() {
      try {
        const url = 'http://localhost:3000/posts';

        // 에러가 나면 여기서 멈추고 catch 코드 실행
        const response = await axios.get(url);
        // const response = await axios({ url: url });

        // json 형태로 자동으로 변환됨
        const data = response.data;
        // setLoading(false);
        setPosts(data);
      } catch (err) {
        setError('무언가의 에러가 났어');
        // setError(err.message)
        // setLoading(false);
      } finally {
        // 에러가 나든 안나든 무조건 실행 : finally
        setLoading(false);
      }
    }

    fetchPosts();
  }, []);

  if (loading) {
    return <div>로딩중</div>;
  }

  if (error) {
    return <div>{error}</div>;
  }

  return (
    <div>
      <h2>posts</h2>
      <label htmlFor="search">게시글 검색 </label>
      <input
        type="text"
        name="search"
        id="search"
        onChange={(e) => setInput(e.target.value)}
      />
      <ul>
        {myInput &&
          posts
            .filter((post) => 
              post.title.includes(myInput))
            .map((post) => {
              return <li key={post.id}>{post.title}</li>;
            })}
      </ul>
      <ul>
        {posts.map((post) => {
          const { id, title, content } = post;
          return (
            <li key={id}>
              <Link to={`/posts/${id}`} state={{ post }}>
                <h3>{title}</h3>
              </Link>
              <h3
                onClick={() => {
                  // 이동을 하고 싶다
                  navigate(`/posts/${id}`);
                }}
              >
                {title}
              </h3>
            </li>
          );
        })}
      </ul>
    </div>
  );
}
