import { useState } from "react";

export default function Signup() {
	let [info, setInfo] = useState({
		id: "",
		pw: "",
		pw2: "",
		email: ""
	});

	const changeHandler = e => {
		// 이벤트ㅌ가 발생한 욧호에 표준속성인 name과 value를 가져옴
		// input, select, textarea가 아니면 name과 value는 표준이 아님.
		const {name, value} = e.target;
		// [name] : 속성명에 변수 값을 쓰기 위해 [변수명]을 활용
		setInfo({...info, [name]: value});
	}

	const submitHandler = e => {
		e.preventDefault();
		// 아이디 유효성 확인

		console.log(info);
		// 비번 유효성 확인
		if (info.pw !== info.pw2) {
			alert("비밀번호가 일치하지 않습니다.");
			return;
		}
		// 비번 비번확인 검사
		signup(info);
	}

	const signup = async info => {
		try {
			const resp = await fetch("/api/v1/auth/signup", {
				method: "POST",
				headers: {
					'Content-Type': 'application/json',
				},
				body: JSON.stringify(info)
			});

			if (!resp.ok) {
				alert("회원가입이 실패했습니다.");
				return;
			}
			const res = resp.json();
			if (res) {
				alert("회원가입이 완료됐습니다");
			} else {
				alert("아이디/이메일이 사용중입니다.");
			}

		} catch (e) {           
			console.error(e);
		}
	}


	return (
		<div>
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
				<div>
					<label htmlFor="pw2">비번확인: </label>
					<input type="password" name="pw2" id="pw2"  onChange={changeHandler}/>
				</div>
				<div>
					<label htmlFor="mail">이메일: </label>
					<input type="email" name="email" id="email" onChange={changeHandler} />
				</div>
				<button>회원가입</button>
			</form>
		</div>
	);
}