// 인증 정보를 headers에 자동으로 추가하는 함수
export async function authFetch(url, options={}) {
	const token = localStorage.getItem('accessToken');
	const headers = {
		"Content-Type": "application/json",
		...(options.headers || {})
	}
	
	// token이 있으면
	if (token) {
		headers.Authorization = `Bearer ${token}`;
	}

	const resp = await fetch(url, {
		...options,
		headers
	});

	if (resp.status === 401) {
		console.log("인증 만료 또는 로그인이 불가합니다.");
		//refresh token 또는 로그아웃 처리 예정
	}
	return resp;
} 