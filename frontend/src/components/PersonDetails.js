import React from 'react';
import PaymentRow from './PaymentRow';

export default function PersonDetails({ person, payments, onUpdate }) {
  if (!person) return null;

  return (
    <div>
      <h2>{person.name}’s 90-Day Schedule</h2>
      <table border="1" cellPadding="4">
        <thead>
          <tr>
            <th>Date</th>
            <th>Expected</th>
            <th>Paid</th>
            <th>Remaining</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {payments.map(p => (
            <PaymentRow key={p.id} payment={p} onUpdate={onUpdate} />
          ))}
        </tbody>
      </table>
    </div>
  );
}
