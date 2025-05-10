import React, { useState } from 'react';
import axios from 'axios';

export default function PersonForm({ onAdded }) {
  const [name, setName] = useState('');
  const [amount, setAmount] = useState('');

  const submit = async () => {
    if (!name || !amount) return;
    await axios.post(`/api/persons?name=${encodeURIComponent(name)}&totalAmount=${amount}`);
    setName(''); setAmount('');
    onAdded();
  };

  return (
    <div>
      <input placeholder="Name" value={name} onChange={e=>setName(e.target.value)} />
      <input placeholder="Amount" type="number" value={amount} onChange={e=>setAmount(e.target.value)} />
      <button onClick={submit}>Add Person</button>
    </div>
  );
}
