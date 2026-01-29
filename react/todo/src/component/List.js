import { useEffect, useState } from "react";
import "./list.css"; 
// 비동기 통신으로 할일 목록 전체를 요청해서 가져온 후 화면에 출력.
// url: /api/v1/todos
// method: get

export default function List() {
	let [todos, setTodos] = useState([]);
	useEffect(() => {
		const getTodos = async () => {
			try {
				const resp = await fetch('/api/v1/todos');
				if (resp.ok) {
					const res = await resp.json();
					setTodos(res);
				}
			} catch (error) {
				console.log(error);
			}
		}

		getTodos();
	}, []);

	const formatTime = (date) => {
		const d = new Date(date);
		return d.getFullYear() + "-"
		     + (d.getMonth()+1).toString().padStart(2, '0') + "-"
				 + (d.getDate()).toString().padStart(2, '0');
	};

	const deleteTodo = async num => {
		try {
			const resp = await fetch(`/api/v1/todos/${num}`, {
				method: "DELETE",
			})
			
			if (resp.status === 200) {
				const res = await resp.text();
				alert(res);
				setTodos(todos.filter(t => t.num !== num));
			}
		} catch (err) {
			console.log(err);
		}
	}

	return (
		<div>
			<h1>할 일 목록</h1>
			<ul class="todo-list">
				{todos.map(todo => (
					<li key={todo.num} className="todo-item">
						<span className="todo-date">{formatTime(todo.date)}</span>
						<span className="todo-text">{todo.text}</span>
						<button className="todo-btn" onClick={() => deleteTodo(todo.num)}>&times;</button>
					</li>
				))}
			</ul>
		</div>
	);
}