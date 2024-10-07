import { useState } from 'react'
import './App.scss'
import Counter from './components/counter/counter'

function App() {
  const [count, setCount] = useState(0)

  return <main>
    <Counter />
  </main>
}

export default App
