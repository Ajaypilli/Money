import React, { useState } from 'react';
import axios from 'axios';

export default function PaymentRow({ payment, onUpdate }) {
  const [paid, setPaid] = useState(payment.paidAmount);

  const save = async () => {
    await axios.put(`/api/payments/${payment.id}?paidAmount=${paid}`);
    onUpdate();
  };

  const remaining = (payment.expectedAmount - paid).toFixed(2);

  return (
    <tr>
      <td>{payment.date}</td>
      <td>₹{payment.expectedAmount.toFixed(2)}</td>
      <td>
        <input 
          type="number" 
          value={paid} 
          onChange={e => setPaid(parseFloat(e.target.value)||0)} 
          style={{ width: '60px' }}
        />
      </td>
      <td>₹{remaining}</td>
      <td><button onClick={save}>Save</button></td>
    </tr>
  );
}
