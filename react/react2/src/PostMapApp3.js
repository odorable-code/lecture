import { useState } from "react";

function PostMapApp3() {
	let [num, setNum] = useState(2);
	let [posts, setPosts] = useState([
		{ num : 1, title: "제목입니다", content: "내용입니다", writer: "홍길동" },
	]);
	let [post, setPost] = useState({
		title: '',
		writer: '',
		content: '',
		num: num,
	})

	const changeHandler = e => {
		console.log(e.target.name, ",", e.target.value);
		 let {name, value} = e.target;
		 setPost({
			...post,
			[name]: value
		 })
	}
	const postInsert = (e) => {
		e.preventDefault();
		if (!post.title.trim()) {
			alert("제목을 입력하세요");
			return;
		}
		if (!post.writer.trim()) {
			alert("작성자를 입력하세요");
			return;
		}
		if (!post.content.trim()) {
			alert("내용을 입력하세요");
			return;
		}
		setPost({
			...post,
			num: num
		})

		setNum(num + 1);
		setPosts([post, ...posts]);
		setPost({
			writer: '',
			title: '',
			content: '',
			num: num,
		})
	}
	return (
		<div>
			<form onSubmit={postInsert}>
				<input type="text" placeholder="제목을 입력하세요" onChange={changeHandler} name="title" value={post.title}/>
				<br/>
				<input type="text" placeholder="작성자를 입력하세요" onChange={changeHandler} name="writer" value={post.writer}/>
				<br/>
				<textarea placeholder="내용을 입력하세요" onChange={changeHandler} name="content" value={post.content}></textarea>
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
									
export default PostMapApp3;