import { BrowserRouter, Routes, Route } from 'react-router-dom'
import NavBar from './component/nav/Navbar';
import List from './component/List';
import Insert from './component/Insert';
import Main from './component/Main';
function App() {
  return (
    <BrowserRouter>
      <NavBar />
      <Routes>
        <Route path={"/"} exact element={<Main />} />
        <Route path={"/todo/list"} element={<List />} />
        <Route path={"/todo/insert"} exact element={<Insert />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
