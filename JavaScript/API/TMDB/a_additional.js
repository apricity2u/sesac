async function getPopularMovies() {
  try {
    const baseURL = 'https://api.themoviedb.org/3/movie';
    // const path = '/popular';
    const path = '/now_playing';
    const params = new URLSearchParams({
      api_key: 'eab8c9893e725b2e167187cef66bae3d',
      language: 'ko',
    });
    // const params = 'api_key=eab8c9893e725b2e167187cef66bae3d&language=ko';

    const URL = `${baseURL}${path}?${params}`;
    // const URL =
    //   'https://api.themoviedb.org/3/movie/popular?api_key=eab8c9893e725b2e167187cef66bae3d';

    const response = await fetch(URL);
    const data = await response.json();

    const movies = data.results;

    // vote_average가 10점이지만, vote_count 가 1이면 신빙성 있는 자료일까?
    // vote_count가 기준치 이하면 거른다..!

    const my_movie = {
      title: 'sesac the movie',

      vote_average: 10.0,
      vote_count: 1,
    };

    movies.push(my_movie);

    let top_vote_average = 0
    let top_vote_average_movie = null

    for (let movie of movies) {
      const vote_average = movie.vote_average;
      const voteCount = movie.vote_count;

      // voteCount가 100이상이면 거른다!
      if (voteCount < 100) continue

      if (vote_average > top_vote_average) {
        top_vote_average = vote_average;
        top_vote_average_movie = movie
      }
    }

    console.log(top_vote_average, top_vote_average_movie);

  } catch (error) {
    console.error('Error:', error);
  }
}

getPopularMovies();
