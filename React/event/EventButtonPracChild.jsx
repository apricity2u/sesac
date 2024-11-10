import React from 'react'

export default function Button({onClick, backgroundColor, color = "white", children}) {

  return (
    <button style = {{backgroundColor : backgroundColor, color}}onClick={onClick}>{children}</button>
  )
}
