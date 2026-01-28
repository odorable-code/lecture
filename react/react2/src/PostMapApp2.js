import { useState } from "react";

// 등록 버튼을 누르면 클릭하면 제목, 작성자, 내용이 콘솔에 출력되도록 작성
function PostMapApp2() {
	let [num, setNum] = useState(2);
	let [posts, setPosts] = useState([
		{ num : 1, title: "제목입니다", content: "내용입니다", writer: "홍길동" },
	]);


	let [title, setTitle] = useState("");
	let [writer, setWriter] = useState("");
	let [content, setContent] = useState("");

	const postInsert = (e) => {
		e.preventDefault();
		// const title = e.target[0].value;
		// const writer = e.target[1].value;
		// const content = e.target[2].value;
		setPosts([...posts,{ num, title, content, writer }]);
		setNum(num + 1);
	}
	return (
		<div>
			<form onSubmit={postInsert}>
				<input type="text" placeholder="제목을 입력하세요" onChange={(e) => setTitle(e.target.value)}/>
				<br/>
				<input type="text" placeholder="작성자를 입력하세요" onChange={(e) => setWriter(e.target.value)}/>
				<br/>
				<textarea placeholder="내용을 입력하세요" onChange={(e) => setContent(e.target.value)}></textarea>
				<br/>
				<button>게시글 등록</button>
			</form>
			<h1>게시글 목록</h1>
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>내용</th>
					</tr>
				</thead>
				<tbody>
					{posts.map( ({ num, title, writer, content }) => (
						<tr key={"post" + num}>
							<td>{num}</td>
							<td>{title}</td>
							<td>{writer}</td>
							<td>{content}</td>
						</tr>
					))}
				</tbody>
			</table>
		</div>
	)
}
                  
export default PostMapApp2;