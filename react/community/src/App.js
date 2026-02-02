import { BrowserRouter, Routes, Route } from 'react-router-dom'
import NavBar from './component/nav/Navbar';
import Main from './component/body/Main';
import Signup from './component/body/Signup';
import Login from './component/body/Login';

function App() {
  return (
    <BrowserRouter>
      <NavBar />
      <Routes>
        <Route path={"/"} exact element={<Main />} />
        <Route path={"/signup"} element={<Signup />} />
        <Route path={"/login"} exact element={<Login />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
