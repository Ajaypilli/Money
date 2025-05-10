import React from 'react';
import { Link } from 'react-router-dom';

export default function PersonList({ persons =[] }) {
  if (!persons.length) return <p>No borrowers yet.</p>;
  return (
    <ul>
      {persons.map(p => (
        <li key={p.id}>
          <Link to={`/person/${p.id}`}>
            {p.name} — ₹{p.totalAmount}
          </Link>
        </li>
      ))}
    </ul>
  );
}
