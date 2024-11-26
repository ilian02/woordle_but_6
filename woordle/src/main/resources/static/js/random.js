const submitButton = document.getElementById('submit-guess');

submitButton.addEventListener('click', () => {
        const guess = document.getElementById('guess').value;
            if (guess.length === 6) {
                alert(`You guessed: ${guess}`);
                // Logic to process guess would go here
            } else {
                alert('Please enter a 6-letter word.');
            }
        });

async function getRandomWord() {
    try {
        const response = await fetch("/random/generate", {method: "GET"})
        if (!response.ok) {
            throw new Error("Error getting word from server")
        }

        const data = await response.json();
        console.log(data.word);
    } catch(e) {
        console.error("Failed to generate random word")
    }
}

window.onload = getRandomWord()