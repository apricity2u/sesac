import api from './axios';

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
