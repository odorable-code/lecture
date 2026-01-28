import { useState } from "react";
import { useNavigate } from "react-router-dom";

function PostInsert() {
	const navigator = useNavigate();
	let [title, setTitle] = useState('');
	let [writer, setWriter] =  useState('');
	let [content, setContent] = useState('');


	const titleChange = e => setTitle(e.target.value);
	const contentChange = e => setContent(e.target.value); 
	const writerChange = e => setWriter(e.target.value);
	const addPost = (e) => {  
		e.preventDefault();
		let post = {
			title,
			writer, 
			content,
		};

		if (!post.title.trim()) {
			alert("제목을 입력하세요.");
			return;
		}
		if (!post.writer.trim()) {
			alert("작성자를 입력하세요.");
			return;
		}
		if (!post.content.trim()) {
			alert("내용을 입력하세요.");
			return;
		}
		sendPost(post);
	}
	const sendPost = async (post) => {
		try {
			const resp = await fetch('/api/v1/posts', { 
				method: 'post',
				headers:  {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(post)
			}
		);

			if (resp.ok) {
				const res = await resp.json();
				if (res) {
					alert("게시글을 등록했습니다.");
					navigator("/posts");
				} else {
					alert("게시글을 등록하지 못했슯니다.");
				}
			}
		} catch (e) {
			console.error(e);
		}
	}
	// 방법2 객체를 이용해서 입력을 받음
	let [post, setPost] = useState({
		title: "",
		writer: "",
		content: "",
	});

	const inputChange = (e) => {
		setPost({
			...post,
			[e.target.name] : e.target.value
		}); 
	};

	const addPost2 = (e) => {
		e.preventDefault();
		if (!post.title.trim()) {
			alert("제목을 입력하세요.");
			return;
		}
		if (!post.writer.trim()) {
			alert("작성자를 입력하세요.");
			return;
		}
		if (!post.content.trim()) {
			alert("내용을 입력하세요.");
			return;
		}
		sendPost(post);
	}
	return (
		<div>
			<h1>게시글 등록</h1>
			<form onSubmit={addPost}>
				<input type="text" name="title" placeholder="제목입력" onChange={titleChange} />
				<br/>
				<input type="text" name="writer" placeholder="작성자 입력" onChange={writerChange}/>
				<br/>
				<input type="text" name="content" placeholder="내용 입력" onClick={contentChange} />
				<br/>
				<button>등록</button>
			</form>
			<h1>게시글 등록 방법2</h1>
			<form onSubmit={addPost2}>
				<input type="text" name="title" placeholder="제목입력" onChange={inputChange} />
				<br/>
				<input type="text" name="writer" placeholder="작성자 입력" onChange={inputChange}/>
				<br/>
				<input type="text" name="content" placeholder="내용 입력" onChange={inputChange}/>
				<br/>
				<button>등록</button>
			</form>
		</div>
	);
}

export default PostInsert;