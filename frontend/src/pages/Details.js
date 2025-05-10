import React, { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import axios from 'axios';
import PersonDetails from '../components/PersonDetails';

export default function Details() {
  const { id } = useParams();
  const [payments, setPayments] = useState([]);
  const [person, setPerson] = useState(null);

  // Fetch data for the person and payments
  useEffect(() => {
    async function load() {
      try {
        const [resPay, resPers] = await Promise.all([
          axios.get(`/api/persons/${id}/payments`),
          axios.get('/api/persons')
        ]);
        setPayments(resPay.data);
        setPerson(resPers.data.find(p => p.id.toString() === id));
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    }
    load();
  }, [id]);  // Runs only when 'id' changes

  return (
    <div>
      <Link to="/">← Back</Link>
      {person 
        ? <PersonDetails person={person} payments={payments} onUpdate={() => {}}/>
        : <div>Loading…</div>
      }
    </div>
  );
}
