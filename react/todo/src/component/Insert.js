import { useState } from "react";

export default function Insert() {
	let [text, setText] = useState('');
	let [date, setDate] = useState('');
	const addTodo = function(evt) {
		evt.preventDefault();
		const sendTodo = async function() {
			try {
				const resp = await fetch('/api/v1/todos', {
					method: 'POST',
					headers: { "Content-Type": "application/json" },
					body: JSON.stringify({
						date, text
					})
				});

				if (resp.status === 200) {
					const msg = await resp.text();
					alert(msg);
					setText("");
					setDate("");
				}
			} catch (err) {
				console.error(err);
				alert(err);
			}
		}
		sendTodo();
	}

  return (
		<div>
			<h1>할 일 등록</h1>
			<form onSubmit={addTodo} className="insert-form">
				<div>
					<label htmlFor="text">할일: </label>
					<input type="text" name="text" placeholder="할 일을 입력하세요" onChange={e => setText(e.target.value)} value={text} />
				</div>
				<div>
					<label htmlFor="date">날짜: </label>
					<input type="date" name="date" placeholder="날짜를 입력하세요" onChange={e => setDate(e.target.value)} value={date} />
				</div>
				<button>등록</button>
			</form>
		</div>
	);                
}