import api from './axios';

// 현재는 posts만 관리하지만, 데이터가 많아지면 endpoint를 따로 관리하는게 좋을 수 있다.
//  const endpoint = {
//    posts : {}
//      get : '',
//      getById : (postId) => `/${postId}`

const postApi = {
  // 1. PostList (GET)
  getPosts: async () => {
    const response = await api.get('');
    return response.data;
  },
  // 2. PostDetails (GET)
  getPostById: async (postId) => {
    const response = await api.get(`/${postId}`);
    return response.data;
  },
  // 3. PostCreate (Post)
  createPost: async (formData) => {
    const response = await api.post('', formData);
    return response.data;
  },
};

export default postApi