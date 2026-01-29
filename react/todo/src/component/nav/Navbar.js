import { Link } from 'react-router-dom';
import "./navbar.css";

const NAV_ITEMS = [
  { label: '메인', path: '/' },
  { label: '조회', path: '/todo/list' },
  { label: '등록', path: '/todo/insert' },
];

export default function NavBar() {
	return (
    <nav className='navbar'>
      <ul className='menu-list'>
        {NAV_ITEMS.map(item => (
          <li className='menu-item' key={item.label + item.path}>
            <Link className='menu-link' to={item.path}>{item.label}</Link>
          </li>
        ))}
      </ul>
    </nav>
	);
}