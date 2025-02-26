const API_URL = "http://localhost:8080/myappdata/articles";

// Funktion zum Anzeigen der Server-Antwort
function showResponse(data) {
    document.getElementById("response").textContent = JSON.stringify(data, null, 2);
}

// ? CREATE (POST)
function createArticle() {
    const article = {
        id: parseInt(document.getElementById("createId").value),  // ID als Eingabefeld
        bezeichnung: document.getElementById("bezeichnung").value,
        beschreibung: document.getElementById("beschreibung").value,
        preisEK: parseFloat(document.getElementById("preisEK").value),
        preisVK: parseFloat(document.getElementById("preisVK").value)
    };

    fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(article)
    })
        .then(response => response.json())
        .then(showResponse)
        .catch(error => console.error("Fehler:", error));
}

// ? READ (GET) - Einzelner Artikel
function getArticle() {
    const id = document.getElementById("articleId").value;
    if (!id) {
        alert("Bitte eine Artikel-ID eingeben.");
        return;
    }

    fetch(`${API_URL}/${id}`)
        .then(response => response.json())
        .then(showResponse)
        .catch(error => console.error("Fehler:", error));
}

// ? READ (GET) - Alle Artikel
function getAllArticles() {
    fetch(API_URL)
        .then(response => response.json())
        .then(showResponse)
        .catch(error => console.error("Fehler:", error));
}

// ? UPDATE (PUT)
function updateArticle() {
    const article = {
        id: parseInt(document.getElementById("updateId").value),  // ID im Body senden
        bezeichnung: document.getElementById("updateBezeichnung").value,
        beschreibung: document.getElementById("updateBeschreibung").value,
        preisEK: parseFloat(document.getElementById("updatePreisEK").value),
        preisVK: parseFloat(document.getElementById("updatePreisVK").value)
    };

    fetch(API_URL, {  // Keine ID in der URL!
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(article)
    })
        .then(response => response.json())
        .then(showResponse)
        .catch(error => console.error("Fehler:", error));
}

// ? DELETE
function deleteArticle() {
    const id = document.getElementById("deleteId").value;
    if (!id) {
        alert("Bitte eine Artikel-ID eingeben.");
        return;
    }

    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })
        .then(response => response.text()) // DELETE gibt oft keinen JSON zurück
        .then(showResponse)
        .catch(error => console.error("Fehler:", error));
}
