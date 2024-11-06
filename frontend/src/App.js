
import React, { useEffect, useState } from 'react';
import { fetchHelloMessage } from './services/api';

function App() {
    const [message, setMessage] = useState('');

    useEffect(() => {
        const getMessage = async () => {
            try {
                const response = await fetchHelloMessage();
                setMessage(response);
            } catch (error) {
                console.error('Failed to fetch message:', error);
            }
        };

        getMessage();
    }, []);

    return (
        <div className="App">
            <h1>React Frontend</h1>
            <p>Message from backend: {message}</p>
        </div>
    );
}

export default App;
