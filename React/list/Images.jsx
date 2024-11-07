export default function Images() {

  const imgUrls = [
    "https://images.dog.ceo/breeds/gaddi-indian/Gaddi.jpg",
    "https://images.dog.ceo/breeds/terrier-westhighland/n02098286_3154.jpg",
    "https://images.dog.ceo/breeds/malamute/n02110063_16752.jpg",
    "https://images.dog.ceo/breeds/bulldog-english/jager-2.jpg",
  ];

  const images = imgUrls.map((imgUrl) => {
    return <div>
      <img src={imgUrl} alt="" width="100" />
    </div>
  })

  return (
    <>{images}</>
  )
}
