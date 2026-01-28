import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import Main from './router1/Main';
import Posts from './router1/Posts';

function RouterEx1 () {
	return (
		<BrowserRouter>
				<ul>
					<li><Link to={"/"}>메인</Link></li>
					<li><Link to={"/posts"}>게시글 목록</Link></li>
				</ul>
			<Routes>
				<Route path="/" exact element={<Main />} />
				<Route path="/posts" element={<Posts />} />
			</Routes>
		</BrowserRouter>

	);
}

export default RouterEx1;