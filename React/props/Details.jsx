export default function Details(props) {

  const {title, content, imgSrc, imgAlt} = props

  const roundImg = {
    width: "100px",
    height: "100px",
    borderRadius: "100%"
  }

  const flexbox = {
    width: "200px",
    height: "200px",
    boxSizing: "borderBox",
    padding: "1rem",
    margin: "1rem",
    textAlign: "center"
  }

  return (
    <div style={flexbox}>
      <img src={imgSrc} alt={imgAlt} style={roundImg} />
      <h5>{title}</h5>
      <p>{content}</p>
    </div>
  )
}
