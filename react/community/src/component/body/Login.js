import { useState } from "react";

export default function Login() {
	let [info, setInfo] = useState({id: "", pw: ""})

	const changeHandler = e => {
		// 이벤트ㅌ가 발생한 욧호에 표준속성인 name과 value를 가져옴
		// input, select, textarea가 아니면 name과 value는 표준이 아님.
		const {name, value} = e.target;
		// [name] : 속성명에 변수 값을 쓰기 위해 [변수명]을 활용
		setInfo({...info, [name]: value});
	}

	const submitHandler = e => {
		e.preventDefault();
		login(info);
	}

	const login = async (info) => {
		try {
			const resp = await fetch("/api/v1/auth/login", {
				method: "POST",
				headers: {
					"Content-Type": "application/json"
				},
				body: JSON.stringify(info)
			});

			if (!resp.ok) {
				alert("로그인 실패!");
				return;
			}

			const res = await resp.json();
			localStorage.setItem("accessToken", res.accessToken);
			alert("로그인 성공!");
		} catch (e) {
			console.error(e);
		}
	}

	return (
		<div>
			<h1>로그인</h1>
			<h1>회원가입</h1>
			<form onSubmit={submitHandler}>
				<div>
					<label htmlFor="id">아이디: </label>
					<input type="text" name="id" id="id" onChange={changeHandler} />
				</div>
				<div>
					<label htmlFor="pw">비번: </label>
					<input type="password" name="pw" id="pw" onChange={changeHandler}/>
				</div>
				<button>로그인</button>
			</form>
		</div>
	);
}