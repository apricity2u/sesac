import React, { useState } from 'react';
import postApi from '../api/postsApi';

export default function CommentForm({ setPost, postId }) {
  const [formData, setFormData] = useState({
    content: '',
  });

  function handleSubmit(e) {
    e.preventDefault();

    async function createComment() {
      try {
        const response = await postApi.createComment(postId, formData);
        const data = response.data;

        setPost((prev) => {
          return {
            ...prev,
            comments: [...prev.comments, data.data],
          };
        });

        setFormData({ content: '' });
      } catch (err) {
        console.log(err.message);
      }
    }
    createComment();
  }

  function handleFormInput(e) {
    const inputValue = e.target.value;
    const key = e.target.name;

    setFormData({
      ...formData,
      [key]: inputValue,
    });
  }

  return (
    <>
      <div>댓글 작성란</div>
      <form onSubmit={handleSubmit}>
        <textarea
          name="content"
          id="content"
          required
          value={formData.content}
          onChange={handleFormInput}
        ></textarea>
        <button>댓글 등록</button>
      </form>
    </>
  );
}
