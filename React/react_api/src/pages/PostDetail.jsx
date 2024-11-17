import axios from 'axios';
import { isNull } from 'lodash';
import React, { useEffect, useState } from 'react';
import { useSelector } from 'react-redux';
import { useLocation, useNavigate, useParams } from 'react-router-dom';

export default function PostDetail() {
  const { postId } = useParams();
  const [post, setPost] = useState();
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();

  useEffect(() => {
    const url = `http://localhost:3000/posts/${postId}`;
    async function fetchPost() {
      try {
        const response = await axios.get(url);
        const data = response.data;
        setPost(data);
      } catch (err) {
        // navigate('/posts')
        // TODO: 나중에 고칠 것
        navigate('/not-found', {replace : true});
        // posts -> posts/123 -> not-found (뒤로 가기하면 not-found 무한루프)
        // replace : true로 하면 posts/123은 건너뛰고 돌아감
      } finally {
        setLoading(false);
      }
    }
    fetchPost();
  }, []);

  if (loading) {
    return <div>로딩중</div>;
  }

  return (
    <div>
      detail
      <h3>{post?.title}</h3>
      <p>{post?.content}</p>
    </div>
  );
}
