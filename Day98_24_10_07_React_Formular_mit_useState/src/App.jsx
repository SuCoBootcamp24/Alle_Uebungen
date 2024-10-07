import './App.scss'
import ApiDataLoader from './components/api/apiDataLoader'
import Counter from './components/counter/counter'
import Formular from './components/formular/formular'

export default function App() {
  return <main>
    <Counter />
    <Formular />
    <ApiDataLoader />
  </main>
};