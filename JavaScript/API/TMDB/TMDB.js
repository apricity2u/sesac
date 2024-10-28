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
    const movie = movies[0];

    console.log(movie.title);
  } catch (error) {
    console.error("Error:", error);
  }
}

getPost();
