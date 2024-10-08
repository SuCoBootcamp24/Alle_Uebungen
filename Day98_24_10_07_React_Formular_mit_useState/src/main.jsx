import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { RouterProvider, createBrowserRouter } from 'react-router-dom'
import App from './App.jsx'
import ApiDataLoader from './components/api/apiDataLoader.jsx'
import Counter from './components/counter/counter.jsx'
import Formular from './components/formular/formular.jsx'
import './index.scss'
import Layout from './layouts/layout.jsx'

const router = createBrowserRouter([
  {
    element: <Layout />,
    children: [
      {
        path: '/',
        element: <App />
      },
      {
        path: "apiLoader",
        element: <ApiDataLoader />
      },
      {
        path: "buttonClicker",
        element: <Counter />
      },
      {
        path:"formular",
        element: <Formular />
      }
    ]
  }


])
createRoot(document.getElementById('root')).render(
  <StrictMode>
    <RouterProvider router={router} />
  </StrictMode>,
)
