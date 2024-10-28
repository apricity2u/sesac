// 현재 상영 중인 영화 중 평점(vote_average)이 7 이상인 영화를 나열하시오.

async function getPost() {
  try {
    const baseURL = "https://api.themoviedb.org/3/movie";
    const path = "/now_playing";
    // const path = "/popular"
    const params = new URLSearchParams({
      api_key: "699fc272ef469704ac75915ee54d9ab6",
      language: "ko",
    });

    // const params = "api_key=699fc272ef469704ac75915ee54d9ab6";

    const URL = `${baseURL}${path}?${params}`;

    const response = await fetch(URL);
    const data = await response.json();

    const movies = data.results;

    const vote_average_upto_7 = [];

    for (let movie of movies) {
      const vote_average = movie.vote_average;

      if (vote_average >= 7) {
        vote_average_upto_7.push(movie);
      }
    }

    console.log(vote_average_upto_7);
  } catch (error) {
    console.error("Error:", error);
  }
}

getPost();
