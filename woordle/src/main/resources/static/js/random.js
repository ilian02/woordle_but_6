const submitButton = document.getElementById('submit-guess')
const rows = document.querySelectorAll('.board-row')
const inputField = document.getElementById('guess')


var number_of_guesses = 0;
var guesses = []
var wanted_word = null;
var playing = true

submitButton.addEventListener('click',async () => {
        const guess = inputField.value
        inputField.value = ""
        if (guess.length === 6 && playing) {
            results = check_word(guess, wanted_word)
            await colourAnswer(guess, results)
            number_of_guesses++
            const allGreen = results.every(color => color === "green");
            if (allGreen) {
                playing = false
                alert("You have the correct word")
            } else if (number_of_guesses == 7) {
                alert("Try again!")
                playing = false
            }
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
        wanted_word = data.word;
        console.log(wanted_word)
    } catch(e) {
        console.error("Failed to generate random word")
    }
}

async function colourAnswer(attemptedWord, result) {
    cells = rows[number_of_guesses].querySelectorAll(".board-cell")
    for (let cellIndex = 0; cellIndex < 6; cellIndex++)
    {
        cells[cellIndex].classList.add(result[cellIndex])
        cells[cellIndex].innerHTML = attemptedWord[cellIndex]
        await new Promise(resolve => setTimeout(resolve, 250));
    }
}

function check_word(word, wanted_word) {

    let results = []
    for (let i = 0; i < 6; i++) {
        if (word[i] === wanted_word[i]) {
            results[i] = "green"
        }
        else if (wanted_word.indexOf(word[i]) > -1) {
            results[i] = "yellow"
        } else {
            results[i] = "grey"
        }
    }

    return results;
}

window.onload = getRandomWord()