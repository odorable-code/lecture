import { authFetch } from "../../api/authfetch";

export default function Main() {
	const fetchHandler = async () => {
		try {
			const resp = await authFetch("/api/v1/auth/test");

			if (!resp.ok) {
				alert("로그인 인증 실패");
				return;
			}

			const res = await resp.json();
			if (res) {
				alert("로그인 인증 확인");
			}
		} catch (e) {
			console.error(e);
		}
	}

	const fetchHandler2 = async () => {
		try {
			const resp = await authFetch("/api/v1/auth/me");

			if (!resp.ok) {
				alert("로그인 인증 실패");
				return;
			}

			const res = await resp.json();
			console.log(res);
		} catch (e) {
			console.error(e);
		}
	}

	return (
		<div>
			<h1>메인</h1>
			<button onClick={fetchHandler}>인증 테스트</button>
			<button onClick={fetchHandler2}>회원 정보 테스트</button>
		</div>
	);
}