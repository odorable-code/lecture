import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

function PostDetail() {
	//url에 있는 게시글 번호를 가져옴 /post/detail/:num으로 처리했기 때문에
	//num으로 받아옴
	const navigator = useNavigate();
	let {num} = useParams();
	// num을 이용해서 비동기 통신으로 게시글 정보를 받아와서 화면을 구성
	let [post, setPost] = useState({});

	useEffect(() => {
		const getPost = async () => {
			try {
				const resp = await fetch(`/api/v1/posts/${num}`);
				if (resp.ok) {
					const po = await resp.json();
					setPost(po);
				}
			} catch (e) {
				console.error(e);
			}
		}
		getPost();
	}, [num]);

	if (Object.keys(post).length === 0) {
		return (
			<div>
				<h1>등록되지 않거나 삭제된 글입니다.</h1>
			</div>
		);
	}
	const date = new Date(post.date);
  const dateString = date.getFullYear() + "/"
									 + (date.getMonth()+1).toString().padStart(2, '0') + "/"
									 + (date.getDate()+1).toString().padStart(2, '0');
	const deletePost = async () => {
		const ok = window.confirm("삭제하시겠습니까?");
		if (!ok) {
			return;
		}

		try {
			const resp = await fetch(`/api/v1/posts/${num}`, {
				method: 'delete'
			});
			if (resp.ok) {
				alert("삭제했습니다.");
				navigator('/posts');
			} else {
				alert("삭제하지 못했습니다.");
			}
		} catch (error) {
			console.log(error);
		}
	};

	return (
		<div>
			<h1>게시물 상세</h1>
			<div>제목: {post.title}</div>
			<div>작성자: {post.writer}</div>
			<div>작성일: {dateString}</div>
			<div>내용</div>
			<div>{post.content}</div>
			<button onClick={deletePost}>삭제</button>
		</div>
	);
}

export default PostDetail;