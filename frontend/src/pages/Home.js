import React, { useState, useEffect } from 'react';
import axios from 'axios';
import PersonList from '../components/PersonList';

export default function Home() {
  const [persons, setPersons] = useState([]);

  useEffect(() => {
    async function fetchData() {
      try {
        const response = await axios.get('/api/persons');
        setPersons(response.data);
      } catch (error) {
        console.error('Error fetching persons:', error);
      }
    }
    fetchData();
  }, []);

  return (
    <div>
      <h1>All Borrowers</h1>
      <PersonList persons={persons} />
    </div>
  );
}
